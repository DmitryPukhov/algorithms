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

        int i1 = 0, i2 = a.length-1, i = (i1 + i2) / 2, iPrev=-1;
        int j1 = 0, j2 = b.length-1, j = (j1 + j2) / 2, jPrev=-1;

        // Find medians of a,b
        while(i2 >= i1 && j2 >= j1 && (iPrev!=i || jPrev!=j )) {

            if (a[i] < b[j]) {
                // Find in left a, right b
                i1 = Math.min(a.length - 1, i + 1);
                j1 = Math.max(0, j - 1);
            } else if (b[j] < a[i]) {
                // Find in right a, left b
                i2 = Math.max(0, i - 1);
                j2 = Math.min(b.length - 1, j + 1);
            } else {
                break;
            }
            iPrev=i;
            jPrev=j;
            i = (i1 + i2) / 2;
            j = (j1 + j2) / 2;
        }

        double res = 0;

        if((a.length + b.length) % 2 == 1) {
            res = Math.min(a[iPrev], b[jPrev]);
        } else {
            res =   (a[iPrev] + b[jPrev]) / 2.0;
        }

        return res;

    }

}
