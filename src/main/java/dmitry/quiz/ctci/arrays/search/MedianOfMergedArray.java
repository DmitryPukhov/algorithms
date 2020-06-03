package dmitry.quiz.ctci.arrays.search;

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
        int i=0,j=0;
//        Search in [imin, imax]:
        while(imin <=imax) {
            i = (imin + imax) / 2;
            j = ((m + n + 1) / 2) - i;
            if (j>0 && i< m && (b[j - 1] > a[i])) {
                //search in[ i + 1, imax]
                imin = i+1;
            }
            else if (i > 0 && j < n &&(a[i - 1] > b[j])){
                //search in[ imin, i - 1]
                imax = i-1;
            }else {
                // Found the answer
                break;
            }
        }

        int median1=0,median2=0;
        if(i==0){
            median1=b[j-1];
        } else if (j==0){
            median1=a[i-1];
        }else{
            median1=Math.max(a[i - 1], b[j - 1]);
        }

        // If odd
        if ((m + n) %2 == 1){
            return median1;
        }

        if(i==m){
            median2=b[j];
        } else if(j==n){
            median2=a[i];
        } else{
            median2=Math.min(a[i],b[j]);
        }

        return (median1 + median2) / 2.0;
    }

}
