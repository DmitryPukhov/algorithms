package dmitry.quiz.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph vertex
 */
public class Node<T> {
    public T value;

    /**
     * Child vertices
     */
    public Node<T>[] children = new Node[]{};

    Node(T value) {
        this.value = value;
    }
}
