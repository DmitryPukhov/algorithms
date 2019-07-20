package dmitry.algorithms.arrays.sort;

/**
 * Created by dima on 1/30/16.
 * Selection sort algorithm
 * O(n^2), in-place, stable
 *
 * The algorithm divides the input list into two parts:
 * the sublist of items already sorted, which is built up from left to right at the front (left) of the list,
 * and the sublist of items remaining to be sorted that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
 * The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order),
 * and moving the sublist boundaries one element to the right.
 */
public class SelectionSort {

    /**
     * Selection sort
     * @param arr array of integers to sort
     */
    public static void sort(int[] arr){

        // Left part - sorted, right - unsorted
        // r - start index of right unsorted part
        for(int r = 0; r < arr.length; r++){
            // Find min element in right part
            int iMin = r;
            for(int i = r; i < arr.length; i++){
                if(arr[i] < arr[iMin]){
                    iMin = i;
                }
            }
            // Add found min unsorted element to left sorted part to the end
            // Swap
            int minElement = arr[iMin];
            arr[iMin] = arr[r];
            arr[r] = minElement;
        }
    }
}
