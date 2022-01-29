public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
        first = last = null;
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        return false;
    }

    public void addHeadNode(Node p) {
        Node q;
        if (isEmpty()) {
            first = p;
            last = p;
        } else {
            q = last;
            q.setNext(p);
            last = p;
        }
    }

    public Node getFirst() {
        return first;
    }
}