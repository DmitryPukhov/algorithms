package dmitry.algorithms.arrays.sort;

import dmitry.algorithms.TestUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by dima on 1/30/16.
 */
public class MergeSortTest  {
    /**
     * Test MergeSort.sort() on given array
     */
    public void testMergeSort(int[] arr){
        System.out.println(String.format("Testing merge sort on input: %s", Arrays.toString(arr)));
        InsertionSort.sort(arr);
        System.out.println(String.format("Result: %s", Arrays.toString(arr)));
        System.out.println();
        assertTrue(TestUtil.isArraySorted(arr));

    }

    @Test public void sort_5(){
        int[] arr = {5,4,3,2,1};
        testMergeSort(arr);
    }

    @Test public void sort_1(){
        int[] arr = {1};
        testMergeSort(arr);
    }

    @Test public void sort_sorted(){
        int[] arr = {1,2,3,4,5};
        testMergeSort(arr);
    }

    @Test public void sort_duplicates(){
        int[] arr = {5,5, 4,4, 3,3, 2,2, 1,1};
        testMergeSort(arr);
    }
}