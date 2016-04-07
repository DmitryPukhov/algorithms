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
        if(a.length == 0 && b.length == 0){
            throw new IllegalArgumentException("At least one array a or be should be not empty");
        }

        // We need n > m
        if(b.length < a.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        double res = -1;

        int imin=0,imax=a.length, m = a.length, n = b.length;
        int i,j;
//        Search in [imin, imax]:
        while(true) {
            i = (imin + imax) / 2;
            j = ((m + n + 1) / 2) - i;
            if (!(j==0 || i==m) && (b[j - 1] > a[i])) {
                //search in[ i + 1, imax]
                imin = i+1;
            }
            else if (!(i==0 || j==n) &&(a[i - 1] > b[j])){
                //search in[ imin, i - 1]
                imax = i-1;
            }else {
                // Found the answer
                break;
            }
        }

        //if ((m + n) is odd:
        if ((m + n) %2 == 1){
            //answer is max(A[i - 1], B[j - 1])
            if(/*a.length == 0 ||*/ i < 1){
                return b[Math.max(j - 1, 0)];

            } else if (/*b.length == 0 ||*/ j < 1){
                return a[Math.max(i - 1, 0)];

            } else {
                return Math.max(a[Math.max(i - 1, 0)], b[Math.max(j - 1, 0)]);
            }
        }
        //if ((m + n) is even:
        else {
            //answer is (max(A[i - 1], B[j - 1]) + min(A[i], B[j])) / 2 return res;
            if(a.length == 0){
                return (b[Math.max(j - 1, 0)] + b[Math.min(Math.max(j, 0), b.length - 1)]) / 2.0;
            } else if(b.length == 0){
                return (a[Math.max(i - 1, 0)] + a[Math.min(Math.max(i, 0), a.length - 1)]) / 2.0;
            } else {
                return (Math.max(a[Math.max(i - 1, 0)], b[Math.max(j - 1, 0)]) + Math.min(a[Math.min(Math.max(i, 0), a.length - 1)], b[Math.min(Math.max(j, 0), b.length - 1)])) / 2.0;
            }
        }
    }

}
