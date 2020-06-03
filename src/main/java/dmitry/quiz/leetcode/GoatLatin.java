package dmitry.quiz.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 The rules of Goat Latin are as follows:

 If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 For example, the word 'apple' becomes 'applema'.

 If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 For example, the word "goat" becomes "oatgma".

 Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 Return the final sentence representing the conversion from S to Goat Latin.

 Example 1:
 Input: "I speak Goat Latin"
 Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

 Example 2:
 Input: "The quick brown fox jumped over the lazy dog"
 Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

 Notes:
 S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 1 <= S.length <= 150.
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        StringBuilder out = new StringBuilder();
        int wordNum = 0;
        String suffix = "";
        char[] s = S.toCharArray();
        for(int i=0; i < s.length; i++) {
            Character letter = s[i];
            // If space, add current word to out and start a new word
            if(letter== ' ') {
                // Add word to out
                //out.append(word);
                out.append(suffix);

                String aSuffix = Collections.nCopies(++wordNum, 'a').stream().map(String::valueOf).collect(Collectors.joining());
                 out.append(aSuffix);
                // Start a new word
                //word = new StringBuilder();
                suffix = "";
                out.append(" ");
            } else {
                // First character
                if(suffix == "") {
                    //If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
                    //For example, the word 'apple' becomes 'applema'.
                    if(vowels.contains(letter)){
                        suffix = "ma";
                        out.append(letter);
                    }
                    // If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
                    // For example, the word "goat" becomes "oatgma".
                    else {
                        suffix = letter + "ma";
                    }
                } else {
                    // Normal character
                    out.append(letter);
                }
            }
        }
        // Append last suffix
        if(suffix != "") {
            out.append(suffix);
            String aSuffix = Collections.nCopies(++wordNum, 'a').stream().map(String::valueOf).collect(Collectors.joining());
            out.append(aSuffix);
        }


        return out.toString();
    }
}
