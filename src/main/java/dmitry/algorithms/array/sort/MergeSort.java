package dmitry.algorithms.array.sort;

/**
 * Created by dima on 1/30/16.
 * Merge Sort algorithm implementation
 * Conceptually, a merge sort works as follows:
 * Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
 * Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.
 */
public class MergeSort {

    /**
     * Do merge sort
     *
     * @param arr array or integers to sort in-place
     */
    public void sort(int[] arr) {
        // Find middle point
        int mid = arr.length / 2;

        // Create and fill left and right arrays
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Sort left and right parts
        sort(left);
        sort(right);

        // Merge left and right into arr
        merge(arr, left, right);

    }

    /**
     * Merge left and right into arr, starting from p index
     *
     * @param arr destination array for merging
     * @param left array1 to merge into destination
     * @param right array2 to merge into destination
     */
    private void merge(int[] arr, int left[], int right[]) {
        int a=0,l =0, r = 0;

        // Merge left and right into a
        while (a < arr.length && l < left.length && r < right.length) {
            if(left[l] < right[r]){
                arr[a] = left[l];
                l++;
            } else {
                arr[a] = right[r];
                r++;
            }
            a++;
        }

        // Merge tail of right or length. Only one while will be executed.
        while(r < right.length){
            arr[a++] = right[r++];
        }
        while(l < left.length){
            arr[a++] = left[l++];
        }
    }
}
