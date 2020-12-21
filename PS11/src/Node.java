public class Node <E extends Comparable<E>> {

    private E value;
    private Node<E> next;

    public Node(E value, Node<E> n) {
        this.value = value;
        next = n;
    }

    public Node (E value) {
        this(value, null);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E e) {
        value = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> node) {
        next = node;
    }



}
