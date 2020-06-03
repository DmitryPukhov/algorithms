package dmitry.algorithms;

import dmitry.quiz.ctci.linkedlists.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 1/29/16.
 *
 * Useful checks for test
 */
public class TestUtil {

    /**
     * Array sorted check
     * @param array the array to check is it sorted or not
     */
    public static boolean isArraySorted(int[] array){
        if(array.length==1){
            return true;
        }

        for(int i = 1; i < array.length;i++){
            if(array[i-1] > array[i]){
                return false;
            }
        }

        return true;
    }


    /**
     * Compare two linked lists.
     *
     * @param otherRoot
     * @return
     */
    public static boolean listsEqual(LinkedListNode root, LinkedListNode otherRoot) {
        LinkedListNode node = root;
        LinkedListNode otherNode = otherRoot;
        while (node.next != null && otherNode.next != null) {
            if (!node.value.equals(otherNode.value)) {
                // Found different node, lists aren't equal
                return false;
            }
            node = node.next;
            otherNode = otherNode.next;
        }
        // Equal only if both lists are ended
        return (node.next == null && otherNode.next == null);
    }

    /**
     * Convert linked list to java list of values
     */
    public static List asList(LinkedListNode root) {
        LinkedListNode node = root;
        List lst = new ArrayList();
        while(node != null) {
            lst.add(node.value);
            node = node.next;
        }
        return (lst);
    }

    /**
     * Build linked list from given items
     */
    public static LinkedListNode<Integer> linkedListOf(Integer... items) {
        LinkedListNode prevNode = null;
        LinkedListNode root = null;
        for (Integer item : items) {
            LinkedListNode curNode = new LinkedListNode(item);
            if (prevNode != null) {
                // Link previous node to current
                prevNode.next = curNode;
            } else {
                // First item, set root to it
                root = curNode;
            }
            prevNode = curNode;
        }

        return root;
    }
}
