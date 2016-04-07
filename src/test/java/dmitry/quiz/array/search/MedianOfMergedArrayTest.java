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
    public double testMedian(int[] a, int[] b) {
        System.out.println(String.format("Median of arrays: %s and %s", Arrays.toString(a), Arrays.toString(b)));
        double m = MedianOfMergedArray.findMedian(a,b);
        System.out.println(String.format("Median is %f", m));
        return m;
    }

    /**
     * One array is empty
     */
    @Test
    public void testEmpty(){
        int[] a = {};
        int[] b = {20};
        double m = testMedian(a,b);

        assertEquals(20,m,0.01);

    }
    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testOdd(){
        int[] a = {1, 2};
        int[] b = {3,};
        double m = testMedian(a,b);

        assertEquals(2,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testOdd4(){
        int[] a = { -43, -25, -18, -15, -10, 9, 39, 40};
        int[] b = {-2};
        double m = testMedian(a,b);

        assertEquals(-10,m,0.01);
    }


    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testOdd3(){
        int[] a = {1, 2};
        int[] b = {3,4,5,6,7};
        double m = testMedian(a,b);

        assertEquals(4,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testOdd2(){
        int[] a = {3};
        int[] b = {1,2};
        double m = testMedian(a,b);

        assertEquals(2,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testEven(){
        int[] a = {1, 2};
        int[] b = {3,4};
        double m = testMedian(a,b);

        assertEquals(2.5,m,0.01);
    }

}
