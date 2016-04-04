package dmitry.quiz.array.search;

/**
 * Created by dima on 3/13/16.
 * <p/>
 * Given 2 sorted array. Find median of merged sorted array. Should be O(log(n)) complexity.
 */
public class MedianOfMergedArray {

    private static double oddMedian(int[] a, int i, int[] b, int j){
        //answer is max(A[i - 1], B[j - 1])
        if(i-1 < 0){
            return b[j-1];
        } else if (j-1 < 0){
            return a[i-1];
        }
        return Math.max(a[i - 1], b[j - 1]);
    }

    private static double evenMedian(int[] a, int i, int[] b, int j){
        // low
        int low;
        if(i-1 < 0){
            low = b[j-1];
        } else if( j-1 < 0){
            low = a[i-1];
        } else {
            low = Math.max(a[i-1],b[j-1]);
        }

        // high
        int high;
        if(i < 0){
            high = b[j];
        } else if (j < 0){
            high = a[i];
        } else {
            high = Math.min(a[i],b[j]);
        }


        return (low + high) / 2;
    }

    /**
     * @param a Sorted array 1
     * @param b Sorted array 2
     * @return the median of merged and sorted array a1,a2
     */
    public static double findMedian(int[] a, int[] b) {

        double res = -1;

        int imin=0,imax=a.length, m = a.length, n = b.length;

//        Search in [imin, imax]:
        while(true) {
            int i = (imin + imax) / 2;
            int j = ((m + n + 1) / 2) - i;
            if (!(j==0 || i==m) && (b[j - 1] > a[i])) {
                //search in[ i + 1, imax]
                imin = i+1;
            }
            else if (!(i==0 || j==n) &&(a[i - 1] > b[j])){
                //search in[ imin, i - 1]
                imax = i-1;
            }else
            //if ((m + n) is odd:
            if ((m + n) %2 == 1){
                //answer is max(A[i - 1], B[j - 1])
                return oddMedian(a, i, b, j);
            }
            //if ((m + n) is even:
            else {
                //answer is (max(A[i - 1], B[j - 1]) + min(A[i], B[j])) / 2 return res;
                return evenMedian(a,i,b,j);
            }
        }

    }

}
