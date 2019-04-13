package dmitry.dmitry.algorithms.tree.binary.traversal;

import dmitry.dmitry.algorithms.tree.binary.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InOrderTraversalTest {

    @Test
    public void traverse() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        ArrayList<Integer> traversal = new InOrderTraversal().traverseInOrderRecursive(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());

        traversal = new InOrderTraversal().traverseInOrderIterative(root);
        assertArrayEquals(new Integer[]{1, 2, 3}, traversal.toArray());


    }
}