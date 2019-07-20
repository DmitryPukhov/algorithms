package dmitry.algorithms.arrays.search;

/**
 * Created by dima on 3/5/16.
 *
 * Classic binary search algorithm implementation
 */
public class BinarySearch {
    /**
     * Search given value in sorted array using binary search
     * @param a sorted array
     * @param b
     * @return index of b in array a or -1
     */
    public static int search(int[] a, int b){
        if(a.length == 0){
            return -1;
        }
        // Process interval from array low ... high, starting from the array itself
        int low = 0, high = a.length -1;
        while(low <= high){
            // Divide array in two parts
            int m = low + (high-low)/2;
            if(b < a[m]){
                // If our value is before middle, next look will be in first part
                high = m-1;
            } else if (b > a[m]){
                // If our value is after middle, next look will be in second part
                low = m+1;
            } else {
                // Cool! Found a value.
                return m;
            }
        }

        // If we are here, not found.
        return -1;
    }
}
