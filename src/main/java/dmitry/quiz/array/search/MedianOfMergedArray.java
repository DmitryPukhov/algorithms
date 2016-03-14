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

        int i1 = 0, i2 = a.length, i = 0;
        int j1 = 0, j2 = b.length, j = 0;

        // Find medians of a,b
        while (true) {
            i = (i1 + i2) / 2;
            j = (j1 + j2) / 2;

            if ((i2 == a.length && j1 == 0)
                    || (j2 == b.length && i1 == 0)
                    ) {
                break;
            }
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


        }

        double res = ((a.length + b.length) % 2 == 1) ?
                Math.max(a[Math.max(0,i - 1)], b[Math.max(0,j - 1)]) :
                (Math.max(a[Math.max(0,i-1)], Math.max(b[Math.max(0,j-1)], 0)) + Math.min(a[i], b[j])) / 2.0;

        return res;

    }

}
