package dmitry.quiz.ctci.sortandsearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SortedMergeTest {
    private SortedMerge sortedMerge;

    @Before
    public void init() {
        // Reset algo under test before each test
        sortedMerge = new SortedMerge();
    }

    @Test
    public void merge_normalCase() {
        int[] a = {2, 4, 6, 0, 0, 0};
        int[] b = {1, 3, 5};
        sortedMerge.merge(a, b);
        assertThat(a, is(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void merge_emptyB() {
        int[] a = {2, 4, 6};
        int[] b = {};
        sortedMerge.merge(a, b);
        assertThat(a, is(new int[]{2, 4, 6}));
    }

    @Test
    public void merge_emptyBoth() {
        int[] a = {};
        int[] b = {};
        sortedMerge.merge(a, b);
        assertThat(a, is(new int[]{}));
    }
}