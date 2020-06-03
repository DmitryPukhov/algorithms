package dmitry.quiz.ctci.graphs;

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
