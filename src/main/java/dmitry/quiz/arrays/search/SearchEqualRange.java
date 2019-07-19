package dmitry.quiz.arrays.search;

/**
 * Created by dima on 3/5/16.
 *
 * Search sequence of equal elements in sorted array
 */
public class SearchEqualRange {

    /**
     *
     * @param a sorted array, repeated values are possible
     * @param b value to search
     * @return [first index of b in a, last index of b in a]
     */
    public static int[] searchRange(int[] a, int b){
        // Find first and last index separately
        int low = findIndex(a,b,true);
        int high = findIndex(a,b,false);
        int[] res = {low,high};
        return res;
    }

    /**
     *
     * @param a
     * @param b
     * @param isLow true if to find low bound, false if to find high bound
     * @return low or high index (depending on isLow parameter) of bbbbbb sequence in a.
     */
    private static int findIndex(int[]a, int b, boolean isLow){
        int low = 0;
        int high = a.length-1;
        int index = -1;
        while(low <= high){
            // Divide array in two parts
            int m = low + (high - low)/2;
            if(b < a[m]){
                // If b in first half, will search in first half
                high = m-1;
            }else if(b > a[m]){
                // If b in second half, will search there
                low = m+1;
            } else if(b == a[m]){
                // We found given value, but maybe it is in the middle of equal sequence 1,2,3,3,3,3,3,4,5...
                index = m;
                // We remembered the index, but continue to search in first or second half
                // If b is there, index will be updated
                if(isLow) {
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            }
        }
        return index;
    }
}
