package dmitry.algorithms.linkedlists;

import dmitry.algorithms.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RemoveDupsTest {
    RemoveDups<Integer> algo = new RemoveDups();

    @Test
    public void removeDupsWoBuffer() {
    }

    @Test
    public void removeDups_empty() {
        assertNull(algo.removeDups(null));
    }


    @Test
    public void removeDups_mainCase() {
        LinkedListNode<Integer> result = algo.removeDups(TestUtil.linkedListOf(1, 1, 2, 2, 2, 3, 3));
        assertThat(TestUtil.asList(result), is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void removeDups_noDups() {
        LinkedListNode<Integer> result = algo.removeDups(TestUtil.linkedListOf(1, 2, 3));
        assertThat(TestUtil.asList(result), is(Arrays.asList(1, 2, 3)));
    }
}