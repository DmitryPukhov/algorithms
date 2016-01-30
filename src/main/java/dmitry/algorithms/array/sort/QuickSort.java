package dmitry.algorithms.array.sort;

/**
 * Created by dima on 1/30/16.
 * <p/>
 * Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller sub-arrays: the low elements and the high elements. Quicksort can then recursively sort the sub-arrays.
 * <p/>
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
     * @param arr
     */
    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length);
    }

    /**
     * Recursive quick sort function
     * @param arr global array
     * @param start inclusive start of array inside global
     * @param end exclusive end of array inside global
     */
    private static void quickSort(int[] arr, int start, int end){
        int p = repartition(arr,start,end);

        if(p==0){
            return;
        }
        quickSort(arr, start, start + p);
        quickSort(arr, start + p,  end);

    }

    /**
     * Repartition array inside global array.
     * Repartitioned array will consist of 2 parts: above and below pivot.
     * Pivot value is the value at 0 index
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int repartition(int[] arr, int start, int end){

        // Pivot
        int p = 0;
        int pVal = arr[p];

        // Move less items to the right, higher items to the left of the pivot
        for(int i = start; i < end; i++){
            // Move to the left if less than pivot
            if(arr[i] < pVal){
                // Swap
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }
        return p;
    }

}
