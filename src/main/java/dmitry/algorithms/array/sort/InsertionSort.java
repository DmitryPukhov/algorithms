package dmitry.algorithms.array.sort;

/**
 * Created by dima on 1/29/16.
 * Insertion sort algorithm implementation
 * O(n^2), in-place, stable
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * Each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 */
public class InsertionSort {

    /**
     * Do insertion sort
     * @param arr array of integers to sort
     */
    public static void sort(int[] arr) {

        // Left part is sorted, right is unsorted. Insert each item from right part to appropriate place in the left.
        // r - start index of right unsorted part
        for (int r = 1; r < arr.length; r++) {
            // Insert to a proper place in left sorted part
            for (int i = r; i > 0 && arr[i - 1] > arr[i]; i--) {
                // swap
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
    }
}
