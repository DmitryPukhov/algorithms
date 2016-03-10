package dmitry.quiz.array.search;

/**
 * Created by dima on 3/6/16.
 * Given sorted array of integer. No duplicates.
 * Find index of where to insert a value.
 * Examples:
 * a = 1,3,4,5 and b = 2 => index = 1
 * a = 1,3,4,5 and b = -1 => index = 0
 * a = 1,3,4,5 and b = 7 => index = 4
 */
public class InsertionIndex {

    /**
     * Find index, where to insert a value
     * @param a sorted array
     * @param b value to insert
     */
    public static int insertionIndex(int[] a, int b){
        int low = 0, high = a.length-1;
        int index = -1;
        while(low <= high){
            // Divide interval in two parts
            int m = low + (high-low)/2;
            int mVal = a[m];
            if(b < mVal){
                // If b in first half, set interval to first half
                high = m-1;
                index = m;
            } else if (mVal <  b) {
                // If b in second half, set interval to second half
                low = m+1;
                index = m;
            } else {
                // If this value found, insertion index will be this
                index = m;
                break;

            }
        }

        // If b does not in a, binary search can find previous element. Insert after than.
        if(index < a.length && index >=0 && a[index] < b){
            index++;
        }

        return index;
    }
}
