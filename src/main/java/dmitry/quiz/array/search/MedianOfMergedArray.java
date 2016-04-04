package dmitry.quiz.array.search;

/**
 * Created by dima on 3/13/16.
 * <p/>
 * Given 2 sorted array. Find median of merged sorted array. Should be O(log(n)) complexity.
 */
public class MedianOfMergedArray {


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
                return Math.max(a[i - 1], b[j - 1]);
            }
            //if ((m + n) is even:
            else {
                //answer is (max(A[i - 1], B[j - 1]) + min(A[i], B[j])) / 2 return res;
                return (Math.max(a[i - 1], b[j - 1]) + Math.min(a[i], b[j])) / 2;
            }
        }

    }

}
