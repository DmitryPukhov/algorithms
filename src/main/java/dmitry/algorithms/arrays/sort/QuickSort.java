package dmitry.algorithms.arrays.sort;

/**
 * Created by dima on 1/30/16.
 * <p/>
 * Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller sub-arrays: the low elements and the high elements. Quicksort can then recursively sort the sub-arrays.
 * <p/>
 * <p>Worst case: O(n^2)</p>
 * <p>Average case: O(n*logn)</p>
 * <p>Best case: O(n*logn)</p></>
 * The steps are:
 * <p/>
 * Pick an element, called a pivot, from the array.
 * Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
 * Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
 * <p/>
 * The base case of the recursion is arrays of size zero or one, which never need to be sorted.
 * <p/>
 * The pivot selection and partitioning steps can be done in several different ways; the choice of specific implementation schemes greatly affects the algorithm's performance.
 */
public class QuickSort {
    /**
     * Do quick sort in-place
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * Recursive quick sort function
     *
     * @param arr global array
     * @param lo  inclusive start of array inside global
     * @param hi  exclusive end of array inside global
     */
    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;

        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);

    }

    /**
     * Repartition array inside global array.
     * Repartitioned array will consist of 2 parts: above and below pivot.
     * Pivot value is the value at 0 index
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(int[] arr, int lo, int hi) {

        // Pivot
        int pivot = arr[hi];

        int i = lo;
        // Move less items to the right, higher items to the left of the pivot
        for (int j = lo; j < hi; j++) {
            // Move to the left if less than pivot
            if (arr[j] < pivot) {
                // Swap arr[i] with arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        // Swap A[i] with pivot
        arr[hi]=arr[i];
        arr[i]=pivot;
         return i;
    }

}
