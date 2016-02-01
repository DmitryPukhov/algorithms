package dmitry.algorithms.array.sort;

/**
 * Created by dima on 1/30/16.
 * <p/>
 * An example of bubble sort. Starting from the beginning of the list, compare every adjacent pair, swap their position if they are not in the right order (the latter one is smaller than the former one). After each iteration, one less element (the last one) is needed to be compared until there are no more elements left to be compared.
 */
public class BubbleSort {
    /**
     * Do bubble sort
     *
     * @param arr
     */
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int bubble = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[bubble] > arr[j]) {
                    // Swap
                    int temp = arr[bubble];
                    arr[bubble] = arr[j];
                    arr[j] = temp;
                    bubble = j;
                }
            }
        }
    }
}
