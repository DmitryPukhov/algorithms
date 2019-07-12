package dmitry.algorithms.array.sort;

import dmitry.algorithms.TestUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by dima on 1/29/16.
 */
public class SelectionSortTest  {

    /**
     * Test InsertionIndex.sort() on given array
     */
    public void testSelectionSort(int[] arr){
        System.out.println(String.format("Selection sort on input: %s", Arrays.toString(arr)));
        SelectionSort.sort(arr);
        System.out.println(String.format("Result: %s", Arrays.toString(arr)));
        System.out.println();
        assertTrue(TestUtil.isArraySorted(arr));

    }

    @Test public void testSort5(){
        int[] arr = {5,4,3,2,1};
        testSelectionSort(arr);
    }

    @Test public void testSort1(){
        int[] arr = {1};
        testSelectionSort(arr);
    }

    @Test public void testSortSorted(){
        int[] arr = {1,2,3,4,5};
        testSelectionSort(arr);
    }

    @Test public void testSortDuplicates(){
        int[] arr = {5,5, 4,4, 3,3, 2,2, 1,1};
        testSelectionSort(arr);
    }

}