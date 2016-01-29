package dmitry.algorithms.array.sort;

import dmitry.algorithms.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * Created by dima on 1/29/16.
 */
public class InsertionSortTest {

    /**
     * Test InsertionSort.sort() on given array
     */
    public void testInsertionSort(int[] arr){
        System.out.println(String.format("Testing insertion sort on input: %s", Arrays.toString(arr)));
        InsertionSort.sort(arr);
        System.out.println(String.format("Result: %s", Arrays.toString(arr)));
        System.out.println();
        assertTrue(TestUtil.isArraySorted(arr));

    }

    @Test public void testSort5(){
        int[] arr = {5,4,3,2,1};
        testInsertionSort(arr);
    }

    @Test public void testSort1(){
        int[] arr = {1};
        testInsertionSort(arr);
    }

    @Test public void testSortSorted(){
        int[] arr = {1,2,3,4,5};
        testInsertionSort(arr);
    }

    @Test public void testSortDuplicates(){
        int[] arr = {5,5, 4,4, 3,3, 2,2, 1,1};
        testInsertionSort(arr);
    }

}