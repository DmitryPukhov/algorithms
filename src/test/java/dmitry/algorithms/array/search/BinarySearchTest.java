package dmitry.algorithms.array.search;


import dmitry.algorithms.TestUtil;
import dmitry.algorithms.array.search.BinarySearch;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testSearchEmpty(){
        int[] a = {};
        int i = testSearch(a,1);
        assertEquals(-1,i);
    }

    @Test
    public void testSearchFirst() {
        int[] a = {1,2,3,4,5};
        int b = 1;
        int i = testSearch(a, b);
        assertEquals(0, i);
    }

    @Test
    public void testSearchLast() {
        int[] a = {1,2,3,4,5};
        int b = 5;
        int i = testSearch(a, b);
        assertEquals(4, i);
    }

    @Test
    public void testSearchMiddle() {
        int[] a = {1,2,3,4,5};
        int b = 4;
        int i = testSearch(a, b);
        assertEquals(3,i);
    }

    @Test
    public void testSearch1Yes() {
        int[] a = {1};
        int b = 1;
        int i = testSearch(a, b);
        assertEquals(0, i);
    }

    @Test
    public void testSearch1No() {
        int[] a = {1};
        int b = 3;
        int i = testSearch(a, b);
        assertEquals(-1, i);
    }
}
