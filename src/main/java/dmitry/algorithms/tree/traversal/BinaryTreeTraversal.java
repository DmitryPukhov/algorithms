package dmitry.algorithms.tree.traversal;

import dmitry.algorithms.tree.TreeNode;


import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeTraversal {

    /**
     * Recursive traversal
     */
    public ArrayList<Integer> postOrderRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(preOrderRecursive(root.left));
        res.addAll(preOrderRecursive(root.right));
        res.add(root.val);
        return res;
    }


    public ArrayList<Integer> postOrderIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack1.isEmpty()) {

            while (curr != null) {
                stack1.push(curr);
                curr = curr.left;
            }

            curr = stack1.pop();
            res.add(curr.val);

            curr = curr.right;
        }
        return res;
    }

    /**
     * Recursive traversal
     */
    public ArrayList<Integer> preOrderRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(preOrderRecursive(root.left));
        res.addAll(preOrderRecursive(root.right));
        return res;
    }


    public ArrayList<Integer> preOrderIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                // Preorder add
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            // curr is null here
            curr = stack.pop();

            curr = curr.right;


        }
        return res;
    }

    public ArrayList<Integer> inOrderRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(inOrderRecursive(root.left));
        res.add(root.val);
        res.addAll(inOrderRecursive(root.right));
        return res;
    }

    public ArrayList<Integer> inOrderIterative(TreeNode root) {
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
