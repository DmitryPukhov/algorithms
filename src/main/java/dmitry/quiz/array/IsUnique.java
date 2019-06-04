package dmitry.quiz.array;

import java.util.*;

/**
 * Task: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 * Solution: move along the string, put characters into hashtable. If already exists, the string
 */
public class IsUnique {

    boolean isUnique(String str) {
        if (str == null) return true;
        // Use array as a hash table. Index is a char, value=true if we met this char.
        boolean[] visitedSymbols = new boolean[128];

        // Hashtable add and get has runtime O(1), so all loop is O(N)
        for (char c : str.toCharArray()) {
            if (visitedSymbols[c]) {
                // We have already seen this char => not unique
                return false;
            }

            visitedSymbols[c] = true;
        }

        return true;
    }
}