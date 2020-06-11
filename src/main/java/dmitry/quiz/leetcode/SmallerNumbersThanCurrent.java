package dmitry.quiz.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 * <p>
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]L
 */
public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Sort input array
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        // Go through sorted array. Position of the element is a number of smaller elements.
        Map<Integer, Integer> ht = new HashMap<>();
        for (int i = 0; i < sortedNums.length; i++) {
            ht.putIfAbsent(sortedNums[i], i);
        }

        // Go through hash table, fill in the result
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = ht.get(nums[i]);
        }
        return res;
    }
}

