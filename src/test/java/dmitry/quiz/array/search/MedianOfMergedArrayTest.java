package dmitry.quiz.array.search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 3/13/16.
 */
public class MedianOfMergedArrayTest {
    /**
     * Test insertion index calculation
     */
    public int testMedian(int[] a, int[] b) {
        System.out.println(String.format("Median of arrays: %s and %s", Arrays.toString(a), Arrays.toString(b)));
        int m = MedianOfMergedArray.findMedian(a,b);
        System.out.println(String.format("Median is %d", m));
        return m;
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testMiddle1(){
        int[] a = {1, 2};
        int[] b = {3};
        int m = testMedian(a,b);
        assertEquals(2,m);
    }

}
