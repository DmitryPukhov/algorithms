package dmitry.quiz.arrays;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j)  continue;
                System.out.println(nums[i] + ", " + nums[j] + ", sum=" + (nums[i] + nums[j]));
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[2];
    }
}
