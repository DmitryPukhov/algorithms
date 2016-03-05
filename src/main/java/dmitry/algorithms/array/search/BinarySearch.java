package dmitry.algorithms.array.search;

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
        int low = 0, high = a.length -1;
        while(low <= high){
            int m = low + (high-low)/2;
            if(a[m] > b){
                high = m-1;
            } else if (a[m] < b){
                low = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
