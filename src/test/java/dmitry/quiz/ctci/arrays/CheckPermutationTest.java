package dmitry.quiz.ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationTest {
    CheckPermutation cp = new CheckPermutation();

    @Test
    public void isPermutation_nulls_true() {
        boolean isPermutation = cp.isPermutation(null, null);
        assertTrue(isPermutation);
    }
    @Test
    public void isPermutation_nullEmpty_false() {
        boolean isPermutation = cp.isPermutation(null, "");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutation_emptyNull_false() {
        boolean isPermutation = cp.isPermutation("", null);
        assertFalse(isPermutation);
    }

    @Test
    public void isPermutation_empty_true() {
        boolean isPermutation = cp.isPermutation("", "");
        assertTrue(isPermutation);
    }

    @Test
    public void isPermutation_empty1_false() {
        boolean isPermutation = cp.isPermutation("", "1");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutation_1Empty_false() {
        boolean isPermutation = cp.isPermutation("1", "");
        assertFalse(isPermutation);
    }

    @Test
    public void isPermutation_equals_true() {
        boolean isPermutation = cp.isPermutation("1", "1");
        assertTrue(isPermutation);
    }

    @Test
    public void isPermutation_different_false() {
        boolean isPermutation = cp.isPermutation("1", "2");
        assertFalse(isPermutation);
    }
    @Test
    public void isPermutation_good_true() {
        boolean isPermutation = cp.isPermutation("123", "321");
        assertTrue(isPermutation);
    }
    @Test
    public void isPermutation_bad_false() {
        boolean isPermutation = cp.isPermutation("123", "1234");
        assertFalse(isPermutation);
    }

}