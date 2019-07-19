package dmitry.quiz.linkedlists;

import dmitry.algorithms.TestUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Special test for {@link RemoveDups::sorted} function
 */
public class RemoveDupsSortedTest {
    RemoveDups algo = new RemoveDups();

    @Test
    public void sorted_normal() {
        LinkedListNode<Integer> root = TestUtil.linkedListOf(2, 3, 1, 1, 2, 3);
        LinkedListNode<Integer> newRoot = algo.sorted(root);
        assertEquals(Arrays.asList(1, 1, 2, 2, 3, 3), algo.toList(newRoot));
    }

    @Test
    public void sorted_single() {
        LinkedListNode<Integer> root = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> newRoot = algo.sorted(root);
        assertEquals(newRoot.value, root.value);
    }

    @Test
    public void sorted_null() {
        LinkedListNode<Integer> newRoot = algo.sorted(null);
        assertNull(newRoot);
    }

}
