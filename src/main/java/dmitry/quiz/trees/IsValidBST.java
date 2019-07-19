package dmitry.quiz.trees;

import dmitry.algorithms.tree.TreeNode;

public class IsValidBST {

    /**
     * Binary search tree is valid when left < node < right
     */
    public boolean isValidBST(TreeNode A) {

        TreeNode node = A;
        if(node == null) return true;

        return isLE(node.left, node.val)
        && isGE(node.right, node.val)
        && isValidBST(node.left)
        && isValidBST(node.right);
    }


    /**
     * Is less or equals
     */
    private boolean isLE(TreeNode node, int value) {
        if (node == null) return true;

        return node.val < value
                && isLE(node.left, value)
                && isLE(node.right, value);
    }

    /**
     * Is greater or equals
     */
    private boolean isGE(TreeNode node, int value) {
        if (node == null) return true;

        return node.val > value
                && isGE(node.left, value)
                && isGE(node.right, value);
    }


}
