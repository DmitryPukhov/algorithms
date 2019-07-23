package dmitry.quiz.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 8.1
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStep {

    /**
     * Memorize previously calculated steps of stairs
     */
    private Map<Integer, Integer> stepsByStairs = new HashMap<>();

    /**
     * Solution. ways(stairs) = sum(steps from stairs-3 to stairs -1) + oneJump
     *
     */
    public int calcSteps(int stairs) {
        // If already calculated and memorized, return it
        if (stepsByStairs.containsKey(stairs)) return stepsByStairs.get(stairs);

        // If stairs is 1,2,3 we can jump there from start.
        int oneJump = stairs <= 3 ? 1 : 0;

        // 3 stair is a longest jump
        int maxJump = 3;

        int ways = oneJump;
        // We can jump to last stair from previous stairs inside maxJump length
        for (int i = Math.max(1, stairs - maxJump - 1); i < stairs; i++) {
            ways += calcSteps(i);
        }
        stepsByStairs.put(stairs, ways);

        return ways;
    }
}
