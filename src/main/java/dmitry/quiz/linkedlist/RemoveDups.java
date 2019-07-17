package dmitry.quiz.linkedlist;

import java.util.*;

/**
 * Task: Remove Dups! Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * So
 */
public class RemoveDups<T extends Comparable<T>> {

    /**
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     * Solution: sort first, then go through and remove if current == previous.
     * Order is not preserved though.
     */
    public LinkedListNode<T> removeDupsWoBuffer(LinkedListNode<T> root) {
        if (root == null || root.next == null) return root;

        // Sort linked list
        root = sorted(root);

        // Remove dups
        LinkedListNode<T> current = root.next;
        LinkedListNode prev = root;
        while (current != null) {
            // Remove dup
            if (current.value == prev.value) {
                prev.next = current.next;
                current = prev.next;
            } else {
                // Take a sstep forward
                prev = current;
                current = current.next;
            }
        }


        return root;
    }

    /**
     * Sort given linked list.
     * Not optimal sorting, but we are concentrating on quiz task, not on perfect sort.
     * In-place sort would be better of course.
     *
     * @param root
     * @return root of sorted linked list
     */
    LinkedListNode<T> sorted(LinkedListNode<T> root) {
        if (root == null) return root;
        List<T> lst = toList(root);

        // Call library method sort
        Collections.sort(lst);

        return toLinkedList(lst);
    }

    /**
     * Transform given list to linked list
     *
     * @return Linked List root
     */
    LinkedListNode<T> toLinkedList(List<T> lst) {
        LinkedListNode<T> newRoot = new LinkedListNode<T>(lst.get(0));
        LinkedListNode<T> curItem = newRoot;
        for (int i = 1; i < lst.size(); i++) {
            curItem.next = new LinkedListNode<T>(lst.get(i));
            curItem = curItem.next;
        }
        return newRoot;
    }

    /**
     * Transform linked list to array list;
     */
    List<T> toList(LinkedListNode<T> root) {
        // Transform to array list
        List<T> lst = new ArrayList<T>();
        LinkedListNode<T> curItem = root;
        while (curItem != null) {
            lst.add(curItem.value);
            curItem = curItem.next;
        }
        return lst;
    }


    /**
     * Solution: go through linked list,  elements into hash table.
     * If hash table already contains the item,
     * remove current item from the list (previous.next = current.next)
     * Runtime O(N)
     */
    public LinkedListNode<T> removeDups(LinkedListNode<T> root) {

        // Store visited items here
        Set<T> visited = new HashSet<T>();

        LinkedListNode<T> prev = null;
        LinkedListNode<T> cur = root;
        while (cur != null) {
            if (visited.contains(cur.value)) {
                // Current item is duplicate of another already visited.
                // Remove current item
                prev.next = cur.next;
            } else {
                // New item, add it to visited set
                visited.add(cur.value);
                prev = cur;
            }
            cur = cur.next;
        }

        // Root is the same
        return root;
    }
}
