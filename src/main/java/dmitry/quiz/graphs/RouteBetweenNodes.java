package dmitry.quiz.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes
 * Solution: use DFS (Depth First Search) from node1 until the end or reaching node2.
 **/
public class RouteBetweenNodes {
    private Set<Node> visited = new HashSet<>();

    boolean isConnected(Node<Integer> node1, Node<Integer> node2) {
        for (Node<Integer> childNode : node1.children) {
            if(visited.contains(childNode)) continue;
            if (childNode.value == node2.value ||
                    isConnected(childNode, node2)) return true;
            visited.add(childNode);
        }
        return false;
    }
}
