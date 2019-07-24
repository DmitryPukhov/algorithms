package dmitry.quiz.sortandsearch;

/**
 * 10.1
 * Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 */
public class SortedMerge {

    /**
     * In-place merge b into a
     */
    public void merge(int[] a, int[] b) {
        // Start filling a from the end of array.
        for (int ia = a.length - b.length - 1, ib = b.length - 1, iaNew = a.length - 1; ib >= 0; ia--, ib--) {
            // Move larger item from a or b to the end of the a
            a[iaNew--] = Math.max(a[ia], b[ib]);
            // Move smaller item to the end of the a
            a[iaNew--] = Math.min(a[ia], b[ib]);
        }
    }
}
