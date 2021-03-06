package dmitry.algorithms.trees.traversal;

import dmitry.algorithms.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class BinaryTreeTraversalTest {

    @Test
    public void preOrder() {

        //Collection
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Recursive
        List<Integer> traversal = new BinaryTreeTraversal().preOrderRecursive(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());

        // Iterative
        traversal = new BinaryTreeTraversal().preOrderIterative(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());
    }

    @Test
    public void inOrder() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        // Recursive
        List<Integer> traversal = new BinaryTreeTraversal().inOrderRecursive(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());

        // Iterative
        traversal = new BinaryTreeTraversal().inOrderIterative(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());
    }

    @Test
    public void postOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(2);
        root.right = right;

        // Recursive
        List<Integer> traversal = new BinaryTreeTraversal().postOrderRecursive(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());

        // Iterative
        traversal = new BinaryTreeTraversal().postOrderIterative(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());
    }
}