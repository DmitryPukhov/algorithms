package dmitry.algorithms.trees;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    /**
     *
     * Parent node - for some algorightms only
     */
    public TreeNode parent;

    public TreeNode(int x) {
        val = x;
    }
}

