package dmitry.quiz.ctci.queues;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;


import org.powermock.reflect.Whitebox;

public class ManyStacksInOneArrayTest {

    @Test
    public void pushPop_singleItem() {
        ManyStacksInOneArray<Integer> stack = new ManyStacksInOneArray<>(3, 10);
        stack.push(1, 1);
        stack.push(2, 2);
        stack.push(3, 3);

        stack.push(1, 1);
        stack.push(2, 2);
        stack.push(3, 3);

        assertThat(stack.pop(1), is(1));
        assertThat(stack.pop(2), is(2));
        assertThat(stack.pop(3), is(3));
    }

    @Test
    public void push_multipleItems() {
        // Push items to different stacks and check private field values
        ManyStacksInOneArray<Integer> stack = new ManyStacksInOneArray<>(3, 10);

        stack.push(1, 1);
        Object[] values = Whitebox.getInternalState(stack, "values");
        assertThat(values, is(new Integer[]{1, null, null, null, null, null, null, null, null, null}));

        stack.push(2, 2);
        values = Whitebox.getInternalState(stack, "values");
        assertThat(values, is(new Integer[]{1, 2, null, null, null, null, null, null, null, null}));

        stack.push(3, 3);
        values = Whitebox.getInternalState(stack, "values");
        assertThat(values, is(new Integer[]{1, 2, 3, null, null, null, null, null, null, null}));

        stack.push(1, 21);
        values = Whitebox.getInternalState(stack, "values");
        assertThat(values, is(new Integer[]{1, 2, 3, 21, null, null, null, null, null, null}));
    }

    @Test
    public void pop_multipleItems() {
        // Pop items from predefined stack
        ManyStacksInOneArray<Integer> stack = new ManyStacksInOneArray<>(3, 10);

        stack.push(1, 1);
        stack.push(2, 2);
        stack.push(3, 3);
        stack.push(1, 21);


        int res = stack.pop(2);
        assertThat(res, is(2));

        res = stack.pop(3);
        assertThat(res, is(3));

        res = stack.pop(1);
        assertThat(res, is(21));

        res = stack.pop(1);
        assertThat(res, is(1));

    }
}