package dmitry.quiz.graphs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes
 */
public class RouteBetweenNodesTest {

    private RouteBetweenNodes algo = new RouteBetweenNodes();

    @Test
    public void isConnected_connected_true() {
        // Create test graph
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node11 = new Node<>(11);
        Node<Integer> node12 = new Node<>(12);
        Node<Integer> node121 = new Node<>(121);
        node1.children = new Node[]{node11, node12};
        node12.children = new Node[]{node121};

        assertTrue(algo.isConnected(node1, node121));
    }

    @Test
    public void isConnected_notConnected_false() {
        // Create test graph
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node11 = new Node<>(11);
        Node<Integer> node12 = new Node<>(12);
        Node<Integer> node121 = new Node<>(121);
        node1.children = new Node[]{node11, node12};
        node12.children = new Node[]{node121};

        assertFalse(algo.isConnected(node11, node121));
    }

}