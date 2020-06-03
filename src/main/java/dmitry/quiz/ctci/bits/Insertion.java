package dmitry.quiz.ctci.bits;

/**
 * 5.1
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
 * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input:
 * N = 10000000000, M = 10011, i=2, j=6
 * Output: N = 10001001100
 */
public class Insertion {
    /**
     * Entry point. Insert m into n
     *
     * @param m number M
     * @param n number N
     * @param i M ends at bit i
     * @param j M starts at bit j
     * @return number N
     */
    public int insert(int n, int m, int i, int j) {
        // Clear bits j-i in n
        int clearMask = getClearMask(i, j);
        int nCleared = n & clearMask;

        // Create mask to insert m onto proper place in n
        int mMask = m << i;

        // Insert bits into n
        int nRes = nCleared | mMask;

        return nRes;
    }

    /**
     * Mask to clear bits from j to i.
     * j should be < i
     */
    private int getClearMask(int i, int j) {
        int mask = 0;
        for (int bitPos = i; bitPos <= j; bitPos++) {
            mask |= 1 << bitPos;
        }

        mask = ~mask;
        return mask;
    }
}
