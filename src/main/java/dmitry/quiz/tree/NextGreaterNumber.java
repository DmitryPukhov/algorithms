package dmitry.quiz.tree;

import dmitry.algorithms.tree.TreeNode;

/**
 * Given a BST node, return the node which has value just greater than the given node.
 * Using recursion is not allowed.
 **/
public class NextGreaterNumber {

    /**
     * Find given node by it's data.
     */
//    private TreeNode find(TreeNode node, int data) {
//        if (node == null) return null;
//        if (node.val == data) return node;
//
//
//
//        TreeNode left = find(node.left, data);
//        if (left != null) return left;
//        return find(node.right, data);
//    }
    private TreeNode find(TreeNode root, int data) {
        if (root == null) return null;
        if (root.val == data) return root;

        TreeNode node = root;
        while (node != null) {
            if (node.val == data) return node;
            node = (node.val > data) ? node.left : node.right;
        }
        return null;
    }

    public TreeNode getSuccessor(TreeNode root, int b) {
        TreeNode current = find(root, b);

        if (current.right != null) {
            // Case1. Successor is min node of right subtree
            TreeNode successor = current.right;
            while (successor.left != null) successor = successor.left;
            return successor;

        } else {
            TreeNode ancestor = root;
            TreeNode successor = null;
            while (ancestor != current) {
                if (current.val < ancestor.val) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }
}
