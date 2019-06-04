package dmitry.quiz.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsUniqueTest {
    IsUnique isUnique = new IsUnique();

    @Test
    public void isUniqueNull(){
        // Null string has no duplicates => unique
        boolean result = isUnique.isUnique(null);
        assertEquals(true, result);
    }

    @Test
    public void isUniqueEmpty(){
        // Empty string has no duplicates => unique
        boolean result = isUnique.isUnique("");
        assertEquals(true, result);
    }

    @Test
    public void isUniqueSingleChar(){
        // Single char is unique
        boolean result = isUnique.isUnique("1");
        assertEquals(true, result);
    }

    @Test
    public void isUniquePositive(){
        boolean result = isUnique.isUnique("1234567890abcdefghijklmnopqrstuvwxyz.,:!?");
        assertEquals(true, result);
    }
    @Test
    public void isUniqueNegative(){
        boolean result = isUnique.isUnique("11234567890abcdefghijklmnopqrstuvwxyz.,:!?");
        assertEquals(false, result);
    }
}