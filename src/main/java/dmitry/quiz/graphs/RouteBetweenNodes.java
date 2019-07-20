package dmitry.quiz.graphs;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes
 * Solution: use BFS (Breadth First Search) from node1 until the end or reaching node2.
 **/
public class RouteBetweenNodes {

    boolean isConnected(Node<Integer> node1, Node<Integer> node2) {
        for (Node<Integer> childNode : node1.children) {
            if (childNode.value == node2.value ||
                    isConnected(childNode, node2)) return true;
        }
        return false;
    }
}
