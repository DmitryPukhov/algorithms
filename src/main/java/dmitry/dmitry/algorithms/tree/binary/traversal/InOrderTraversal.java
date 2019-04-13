package dmitry.dmitry.algorithms.tree.binary.traversal;

import dmitry.dmitry.algorithms.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    /**
     * Recursive traversal
     */
    public ArrayList<Integer> traverseInOrderRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(traverseInOrderRecursive(root.left));
        res.add(root.val);
        res.addAll(traverseInOrderRecursive(root.right));
        return res;
    }

    public ArrayList<Integer> traverseInOrderIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);

            curr = curr.right;
        }
        return res;
    }
}
