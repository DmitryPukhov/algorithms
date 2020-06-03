package dmitry.quiz.ctci.linkedlists;

/**
 * Single linked list node with value and next node link;
 * Cannot use standard Java LinkedList because it restricted access to Node class.
 * We cannot add and remove from any place with constant
 *
 */
public class LinkedListNode<T> {
    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
    }
}
