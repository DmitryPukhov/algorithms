package dmitry.quiz.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationTest {
    CheckPermutation cp = new CheckPermutation();

    @Test
    public void isPermutationNulls() {
        boolean isPermutation = cp.isPermutation(null, null);
        assertTrue(isPermutation);
    }
    @Test
    public void isPermutationNullEmpty() {
        boolean isPermutation = cp.isPermutation(null, "");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutationEmptyNull() {
        boolean isPermutation = cp.isPermutation("", null);
        assertFalse(isPermutation);
    }

    @Test
    public void isPermutationEmpty() {
        boolean isPermutation = cp.isPermutation("", "");
        assertTrue(isPermutation);
    }

    @Test
    public void isPermutationStr1Empty() {
        boolean isPermutation = cp.isPermutation("", "1");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutationStr2Empty() {
        boolean isPermutation = cp.isPermutation("1", "");
        assertFalse(isPermutation);
    }

    @Test
    public void isPermutationGoodSingle() {
        boolean isPermutation = cp.isPermutation("1", "1");
        assertTrue(isPermutation);
    }

    @Test
    public void isPermutationBadSingle() {
        boolean isPermutation = cp.isPermutation("1", "2");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutationGood123() {
        boolean isPermutation = cp.isPermutation("123", "321");
        assertTrue(isPermutation);
    }
    @Test
    public void isPermutationBad123() {
        boolean isPermutation = cp.isPermutation("123", "1234");
        assertFalse(isPermutation);
    }

}