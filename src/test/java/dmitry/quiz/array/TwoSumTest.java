package dmitry.quiz.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = new TwoSum().twoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, res);

    }
}