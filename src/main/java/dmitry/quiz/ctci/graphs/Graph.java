package dmitry.quiz.ctci.graphs;

public class Graph<T> {
    public Node<T>[] vertices;

    public void Graph(Node<T>... vertices) {
        this.vertices = vertices;

    }
}
