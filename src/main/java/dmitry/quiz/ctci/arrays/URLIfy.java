package dmitry.quiz.ctci.arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
public class URLIfy {

    public String urlIfy(String str, int strLen) {
        if (strLen <= 0) return str;
        char[] arr = str.toCharArray();
        // Walk from left to right, move chars from p1 to p2.
        // p2 starts from the end including extra space. p1 starts from the "true" lengh of the string.
        int p1 = strLen - 1;
        int p2 = str.length() - 1;

        while (p1 >= 0) {
            char c = arr[p1];
            if (c == ' ') {
                // Insert whitespace
                arr[p2--] = '0';
                arr[p2--] = '2';
                arr[p2--] = '%';
                p1--;
            } else {
                // Move character as is
                arr[p2--] = arr[p1--];
            }
        }

        return String.valueOf(arr);
    }
}
