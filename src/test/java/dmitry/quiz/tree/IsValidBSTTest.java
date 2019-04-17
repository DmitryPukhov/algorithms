package dmitry.quiz.tree;

import dmitry.algorithms.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class IsValidBSTTest {
    IsValidBST testedInstance = new IsValidBST();

    @Test
    /**
     * Tree:
     *   1
     * 2   3
     */
    public void isValidBST_123() {
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
    public void isValidBST_213() {
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
    public void isValidBST_11_4_2_5_1_5() {
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
    public void isValidBST_11_3_2_4_1_3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        boolean isValid = testedInstance.isValidBST(root);
        Assert.assertFalse(isValid);

    }
}