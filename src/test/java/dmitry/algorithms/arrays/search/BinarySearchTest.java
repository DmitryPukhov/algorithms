package dmitry.algorithms.arrays.search;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 3/5/16.
 */
public class BinarySearchTest {

    /**
     * Test BubbleSort.sort() on given array
     */
    public int testSearch(int[] a, int b) {
        System.out.println(String.format("Binary search of %d in array: %s", b, Arrays.toString(a)));
        int i = BinarySearch.search(a, b);
        System.out.println(String.format("Index of %d is %d", b, i));
        return i;
    }

    @Test
    public void search_empty(){
        int[] a = {};
        int i = testSearch(a,1);
        assertEquals(-1,i);
    }

    @Test
    public void search_first() {
        int[] a = {1,2,3,4,5};
        int b = 1;
        int i = testSearch(a, b);
        assertEquals(0, i);
    }

    @Test
    public void search_last() {
        int[] a = {1,2,3,4,5};
        int b = 5;
        int i = testSearch(a, b);
        assertEquals(4, i);
    }

    @Test
    public void search_middle() {
        int[] a = {1,2,3,4,5};
        int b = 4;
        int i = testSearch(a, b);
        assertEquals(3,i);
    }

    @Test
    public void search_1_yes() {
        int[] a = {1};
        int b = 1;
        int i = testSearch(a, b);
        assertEquals(0, i);
    }

    @Test
    public void search_1_no() {
        int[] a = {1};
        int b = 3;
        int i = testSearch(a, b);
        assertEquals(-1, i);
    }
}
