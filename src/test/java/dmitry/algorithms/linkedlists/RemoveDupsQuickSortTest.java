package dmitry.algorithms.linkedlists;

import dmitry.algorithms.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Special test for {@link RemoveDups.QuickSort} inner class
 */
public class RemoveDupsQuickSortTest {
    RemoveDups.QuickSort algo = new RemoveDups().new QuickSort();

    @Test
    public void partition() {
        LinkedListNode<Integer> root = TestUtil.linkedListOf(2, 3, 1, 1, 2, 3);
        LinkedListNode<Integer>[] lowPivotHi = algo.partition(root, null);
        List<Integer> low = TestUtil.asList(lowPivotHi[0]);
        Integer pivot = lowPivotHi[1].value;
        List<Integer> high = TestUtil.asList(lowPivotHi[0]);

        ass
        assertTrue(low.stream().max(Integer::compareTo).get() <= pivot);
        assertTrue(high.stream().min(Integer::compareTo).get() >= pivot);

    }
}
