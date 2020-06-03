package dmitry.quiz.ctci.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IsUniqueTest {
    IsUnique isUnique = new IsUnique();

    @Test
    public void isUnique_null_true(){
        // Null string has no duplicates => unique
        boolean result = isUnique.isUnique(null);
        assertEquals(true, result);
    }

    @Test
    public void isUnique_empty_true(){
        // Empty string has no duplicates => unique
        boolean result = isUnique.isUnique("");
        assertEquals(true, result);
    }

    @Test
    public void isUnique_singleChar_true(){
        // Single char is unique
        boolean result = isUnique.isUnique("1");
        assertEquals(true, result);
    }

    @Test
    public void isUnique_unique_true(){
        boolean result = isUnique.isUnique("1234567890abcdefghijklmnopqrstuvwxyz.,:!?");
        assertEquals(true, result);
    }
    @Test
    public void isUnique_notUnique_false(){
        boolean result = isUnique.isUnique("11234567890abcdefghijklmnopqrstuvwxyz.,:!?");
        assertEquals(false, result);
    }
}