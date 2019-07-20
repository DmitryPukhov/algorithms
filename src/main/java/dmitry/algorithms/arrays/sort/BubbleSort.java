package dmitry.algorithms.arrays.sort;

/**
 * Created by dima on 1/30/16.
 * <p>Bubble sort implementation</p>
 * <p>O(n^2), in-place</p>
 * <p>
 * An example of bubble sort. Starting from the beginning of the list, compare every adjacent pair, swap their position if they are not in the right order (the latter one is smaller than the former one). After each iteration, one less element (the last one) is needed to be compared until there are no more elements left to be compared.
 * </p>
 */
public class BubbleSort {
    /**
     * Do bubble sort
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i] > arr[i + 1]) {
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
        } while(swapped);
    }
}
