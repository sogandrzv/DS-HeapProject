public class Node {
    private int info;
    private Node next;
    private Node previous;
    private Node nextBin;
    private Node previousBin;

    public Node(int info) {
        setInfo(info);
        setNext(null);
        setPrevious(null);
        setNextBin(null);
        setPreviousBin(null);
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNextBin() {
        return nextBin;
    }

    public void setNextBin(Node nextBin) {
        this.nextBin = nextBin;
    }

    public Node getPreviousBin() {
        return previousBin;
    }

    public void setPreviousBin(Node previousBin) {
        this.previousBin = previousBin;
    }
}
