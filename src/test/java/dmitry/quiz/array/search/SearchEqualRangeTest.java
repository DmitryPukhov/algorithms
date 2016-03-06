package dmitry.quiz.array.search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 3/5/16.
 *
 * Search equal range quiz.
 * Given sorted array, some values can repeat.
 * Find first and last index of
 */
public class SearchEqualRangeTest {

    /**
     * Test SearchEqualRange.search() on given array and range
     */
    public int[] testSearch(int[] a, int b) {
        System.out.println(String.format("Search range of %d in sorted array: %s", b, Arrays.toString(a)));
        int[] range  = SearchEqualRange.searchRange(a, b);
        System.out.println(String.format("Range of %d is [%d...%d]", b, range[0],range[1]));
        return range;
    }

    @Test
    public void testSearchEmpty() {
        int[] a = {};
        int b = 0;
        int[] range = testSearch(a, b);
        assertEquals(-1,range[0]);
        assertEquals(-1,range[1]);
    }

    @Test
    public void testSearchMiddle() {
        int[] a = {1,2,3,4,4,4,4,4,5};
        int b = 4;
        int[] range = testSearch(a, b);
        assertEquals(3,range[0]);
        assertEquals(7,range[1]);
    }

    @Test
    public void testSearchNo() {
        int[] a = {1,2,3,4,4,4,4,4,5};
        int b = 7;
        int[] range = testSearch(a, b);
        assertEquals(-1,range[0]);
        assertEquals(-1,range[1]);
    }

    @Test
    public void testSearchStart() {
        int[] a = {1,1,1,2,3,4,5};
        int b = 1;
        int[] range = testSearch(a, b);
        assertEquals(0,range[0]);
        assertEquals(2,range[1]);
    }
    @Test
    public void testSearchEnd() {
        int[] a = {1,2,3,4,4,4,4,4};
        int b = 4;
        int[] range = testSearch(a, b);
        assertEquals(3,range[0]);
        assertEquals(7,range[1]);
    }
    @Test
    public void testSingle() {
        int[] a = {1};
        int b = 1;
        int[] range = testSearch(a, b);
        assertEquals(0,range[0]);
        assertEquals(0,range[1]);
    }

}
