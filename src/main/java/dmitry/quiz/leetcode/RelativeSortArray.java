package dmitry.quiz.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> out = new ArrayList();

        // Fill in arr1Counts map: arr1 value -> number of occurrences in arr1
        Map<Integer, Integer> arr1Counts = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            // Increment counter
            arr1Counts.merge(arr1[i], 1, Integer::sum);
        }

        // Add to out values from arr1 contained in arr2 in arr2 order
        for (int i = 0; i < arr2.length; i++) {
            Integer val = arr2[i];
            if (arr1Counts.containsKey(val)) {
                // Fill out m times
                for (int j = 0; j < arr1Counts.get(val); j++) {
                    out.add(val);
                }
                // Remove processed elements
                arr1Counts.remove(val);
            }
        }

        // Now arr1 contains values which are not in arr2.
        // Sort them and append to result
        List<Integer> leftValues = arr1Counts.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer leftVal : leftValues) {
            // Append this value several times
            Integer leftValCount = arr1Counts.get(leftVal);
            for (int i = 0; i < leftValCount; i++) {
                out.add(leftVal);
            }
        }

        // Convert out List to int[] and return
        return out.stream().mapToInt(Integer::valueOf).toArray();
    }
}
