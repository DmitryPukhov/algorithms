package dmitry.quiz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RelativeSortArrayTest {
    RelativeSortArray alg = new RelativeSortArray();

    @Test
    void relativeSortArrayTest_normalArrays() {
        int[] res = alg.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, res);
    }

    @Test
    void relativeSortArrayTest_singleArr2() {
        int[] res = alg.relativeSortArray(new int[]{5, 4, 3, 1, 1, 1, 1}, new int[]{5});
        assertArrayEquals(new int[]{5, 1, 1, 1, 1, 3, 4}, res);
    }

    @Test
    void relativeSortArrayTest_cornerCases() {
        int[] res = alg.relativeSortArray(new int[]{1}, new int[]{1});
        assertArrayEquals(new int[]{1}, res);

        res = alg.relativeSortArray(new int[]{1, 1}, new int[]{1});
        assertArrayEquals(new int[]{1, 1}, res);

        res = alg.relativeSortArray(new int[]{1, 2, 2}, new int[]{2});
        assertArrayEquals(new int[]{2, 2, 1}, res);

    }

}