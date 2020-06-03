package dmitry.quiz.ctci.trees;

import dmitry.algorithms.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class IsValidBSTTest {
    IsValidBST testedInstance = new IsValidBST();

    /**
     * Tree:
     *   1
     * 2   3
     */
    @Test
    public void isValidBST__123_valid() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        Boolean isValid = testedInstance.isValidBST(root);
        Assert.assertTrue(isValid);
    }

    /**
     * Tree:
     * 2
     * 1   3
     */
    @Test
    public void isValidBST__213_invalid() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        Boolean isValid = testedInstance.isValidBST(root);
        Assert.assertFalse(isValid);
    }

    /**
     * 4 2 5 1 5 -1 -1 -1 -1 -1 -1
     */
    @Test
    public void isValidBST__11_4_2_5_1_5__invalid() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        boolean isValid = testedInstance.isValidBST(root);
        Assert.assertFalse(isValid);

    }

    /**
     * 3 2 4 1 3 -1 -1 -1 -1 -1 -1
     */
    @Test
    public void isValidBST__11_3_2_4_1_3__invalid() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        boolean isValid = testedInstance.isValidBST(root);
        Assert.assertFalse(isValid);

    }
}