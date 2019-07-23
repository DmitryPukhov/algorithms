package dmitry.algorithms.trees.traversal;

import dmitry.algorithms.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (!stack.isEmpty() && stack.peek() == node.right) {
                TreeNode right = stack.pop();
                stack.push(node);
                node = right;
            } else {
                traversed.add(node.val);
                node = null;
            }
        }

        return traversed;
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

    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                traversed.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return traversed;
    }


    public ArrayList<Integer> inOrderRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(inOrderRecursive(root.left));
        res.add(root.val);
        res.addAll(inOrderRecursive(root.right));
        return res;
    }

    /**
     * In order traversal
     */
    public List<Integer> inOrderIterative(TreeNode root) {
        TreeNode node = root;

        List<Integer> traversed = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.empty()) {

            // Go leftwise
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Node is null here, get last. It's left side is null or already traversed
            node = stack.pop();
            traversed.add(node.val);
            // Traverse right node
            node = node.right;
        }

        return traversed;

    }
}
