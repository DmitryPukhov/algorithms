package dmitry.quiz.array.search;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Created by dima on 3/6/16.
 */
public class InsertionSortTest {
    /**
     * Test insertion index calculation
     */
    public int testInsertion(int[] a, int b) {
        System.out.println(String.format("Insert %d into sorted array: %s", b, Arrays.toString(a)));
        int i = InsertionSort.insertionIndex(a,b);
        System.out.println(String.format("Insertion index of %d is %d", b, i));
        return i;
    }

    /**
     * Insert into middle, odd numbers in array
     */
    @Test
    public void testMiddle1(){
        int[] a = {1, 2, 4, 5};
        int b = 3;
        int i = testInsertion(a, b);
        assertEquals(2,i);
    }

    /**
     * Insert into middle, even numbers in array
     */
    @Test
    public void testMiddle2(){
        int[] a = {1, 2, 4, 5, 6};
        int b = 3;
        int i = testInsertion(a, b);
        assertEquals(2,i);
    }

    /**
     * Insert value, equal to first element
     */
    @Test
    public void testFirstExist(){
        int[] a = {1, 2, 4, 5};
        int b = 1;
        int i = testInsertion(a, b);
        assertEquals(0,i);
    }

    /**
     * Insert value before first
     */
    @Test
    public void testFirstNotExist(){
        int[] a = {1, 2, 4, 5};
        int b = -1;
        int i = testInsertion(a, b);
        assertEquals(0,i);
    }
    /**
     * Insert value, equal to last element
     */
    @Test
    public void testLastExist(){
        int[] a = {1, 2, 4, 5};
        int b = 5;
        int i = testInsertion(a, b);
        assertEquals(3,i);
    }

    /**
     * Insert value after last element
     */
    @Test
    public void testLastNotExist(){
        int[] a = {1, 2, 4, 5};
        int b = 6;
        int i = testInsertion(a, b);
        assertEquals(4,i);
    }


}
