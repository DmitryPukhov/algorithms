package dmitry.quiz.ctci.arrays.search;

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
    public void findMedian_empty(){
        int[] a = {};
        int[] b = {20};
        double m = testMedian(a,b);

        assertEquals(20,m,0.01);

    }
    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_odd(){
        int[] a = {1, 2};
        int[] b = {3,};
        double m = testMedian(a,b);

        assertEquals(2,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_odd4(){
        int[] a = { -43, -25, -18, -15, -10, 9, 39, 40};
        int[] b = {-2};
        double m = testMedian(a,b);

        assertEquals(-10,m,0.01);
    }


    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_odd3(){
        int[] a = {1, 2};
        int[] b = {3,4,5,6,7};
        double m = testMedian(a,b);

        assertEquals(4,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_odd2(){
        int[] a = {3};
        int[] b = {1,2};
        double m = testMedian(a,b);

        assertEquals(2,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_even(){
        int[] a = {1, 2};
        int[] b = {3,4};
        double m = testMedian(a,b);

        assertEquals(2.5,m,0.01);
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void findMedian_even2(){
        int[] a = {-24, -11, -7, 4, 21, 26};
        int[] b = { 25, 44};
        double m = testMedian(a,b);

        assertEquals(12.5,m,0.01);
    }
}
