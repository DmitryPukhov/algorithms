package dmitry.quiz.arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other. What if you
 * cannot use additional data structures?
 */
public class CheckPermutation {

    public boolean isPermutation(String str1, String str2) {
        if (str1 == null && str2 == null) return true;
        // Xor: one null, another is not
        if (str1 == null ^ str2 == null) return false;
        if (str1.length() != str2.length()) return false;


        // For input strings map characters to it's number in the string
        int[] t1 = new int[128];
        int[] t2 = new int[128];
        // n i a length of s1 and s2.
        for (int i = 0; i < str1.length(); i++) {

            // Update hash table 1
            char c1 = str1.charAt(i);
            t1[c1] = ++t1[c1];
            // Update tash table 2
            char c2 = str2.charAt(i);
            t2[c2] = ++t2[c2];
        }

        // 2 hash tables should be equal
        for (int i = 0; i < 128; i++) {
            if (t1[i] != t2[i]) return false;
        }
        return true;
    }

}
