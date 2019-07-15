package dmitry.algorithms.linkedlists;

import java.util.*;

/**
 * Task: Remove Dups! Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * So
 */
public class RemoveDups<T> {

    /**
     * Sort linked list ising in-place Quick Sort algorithm.
     */
    class QuickSort<T> {

        public LinkedListNode<T> sort(LinkedListNode<T> root) {
            LinkedListNode<T> tail = getTail(root);

            LinkedListNode<T>[] lowPivotHigh = partition(root, tail);
            LinkedListNode<T> low = lowPivotHigh[0];
            LinkedListNode<T> pivot = lowPivotHigh[1];
            LinkedListNode<T> high = lowPivotHigh[2];

            return root;
        }

        /**
         * @param root root node of linked list fragment
         * @param tail tail node of linked list fragment
         * @return low partition root, pivot, high partition root
         */
        LinkedListNode<T>[] partition(LinkedListNode<T> root, LinkedListNode<T> tail) {

            LinkedListNode<T> pivot = root;
            LinkedListNode<T> lowRoot = null;
            LinkedListNode<T> lowTail = null;
            LinkedListNode<T> highRoot = null;
            LinkedListNode<T> highTail = null;

            LinkedListNode<T> current = root.next;

            while (current != tail) {
                // Who said that values must be comparable?
                /// So we sort linked list by hash codes, not values themselves.
                if (current.value.hashCode() >= pivot.value.hashCode()) {
                    // Add to higher partition
                    if (highTail == null) {
                        highRoot = current;
                        highTail = current;
                    } else {
                        highTail.next = highTail = current;
                        highTail.next = null;
                    }
                } else {
                    // Add to lower partition
                    if (lowTail == null) {
                        lowRoot = current;
                        lowTail = current;
                    } else {
                        lowTail.next = lowTail = current;
                        lowTail.next = pivot;
                    }
                }
                current = current.next;
            }

            // New linked list: low, root, high
            //lowTail.next = root;
            pivot.next = highRoot;

            if(lowRoot != null) partition(lowRoot, pivot);
            if(highRoot != null) partition(pivot, highRoot);

            // Return something like tuple3
            LinkedListNode[] arr = {lowRoot, pivot, highRoot};
            return arr;
        }

        LinkedListNode<T> getTail(LinkedListNode<T> root) {
            LinkedListNode<T> tail = root;
            // Just move until the end
            while (tail != null && tail.next != null) tail = tail.next;
            return tail;
        }
    }

    public LinkedListNode<T> removeDupsWoBuffer(LinkedListNode<T> root) {


        return null;
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
