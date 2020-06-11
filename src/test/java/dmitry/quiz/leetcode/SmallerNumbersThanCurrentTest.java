package dmitry.quiz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallerNumbersThanCurrentTest {

    SmallerNumbersThanCurrent alg = new SmallerNumbersThanCurrent();
    @Test
    void smallerNumbersThanCurrent() {
        assertArrayEquals(new int[]{4,0,1,1,3}, alg.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
        assertArrayEquals(new int[]{2,1,0,3}, alg.smallerNumbersThanCurrent(new int[]{6,5,4,8}));
        assertArrayEquals(new int[]{0,0,0,0}, alg.smallerNumbersThanCurrent(new int[]{7,7,7,7}));

    }
}