package dmitry.quiz.trees;

import dmitry.algorithms.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextGreaterNumberTest {
    private TreeNode createTree() {
//           100
//          /   \
//       98     102
//      /  \
//     96   99
//       \
//        97

        TreeNode node96 = new TreeNode(96);
        TreeNode node97 = new TreeNode(97);
        TreeNode node98 = new TreeNode(98);
        TreeNode node99 = new TreeNode(99);
        TreeNode node100 = new TreeNode(100);
        TreeNode node102 = new TreeNode(102);

        node100.left = node98;
        node98.parent = node100;

        node98.left = node96;
        node96.parent = node98;

        node96.right = node97;
        node97.parent = node96;

        node98.right = node99;
        node99.parent = node98;

        node100.right = node102;
        node102.parent = node100;

        return node100;
    }


    @Test
    public void getSuccessor() {
        TreeNode root = createTree();
        NextGreaterNumber algo = new NextGreaterNumber();
        int result = algo.getSuccessor(root, 97).val;
        assertEquals(98, result);

    }
}