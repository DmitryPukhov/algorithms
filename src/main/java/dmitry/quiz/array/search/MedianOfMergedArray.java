package dmitry.quiz.array.search;

/**
 * Created by dima on 3/13/16.
 *
 * Given 2 sorted array. Find median of merged sorted array. Should be O(log(n)) complexity.
 */
public class MedianOfMergedArray {

    /**
     *
     * @param a Sorted array 1
     * @param b Sorted array 2
     * @return the median of merged and sorted array a1,a2
     */
    public static int findMedian(int[] a, int[] b){

        int i1=0,i2=a.length-1;
        int j1=0,j2=b.length-1;

        // Find medians of a,b
        while(i1 <=i2 && j1 <=j2) {
            int i = (i1+i2)/2;
            int j = (j1+j2)/2;
            if (a[i] < b[j]) {
                // Find in left a, right b
                i1=i+1;
                j1=j-1;
            } else {
                // Find in right a, left b
                i2=i-1;
                j2=j+1;
            }
        }

        // Only interval inside a or b left for median
        int median = (i2 >=i1)?
            a[i1+i2]/2
        :
            b[j1+j2]/2;

        return median;




    }

}
