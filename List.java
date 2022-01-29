public class List {
    private Node head;
    private final int initialMemory;//first memory
    private int remainingMemory;
    private Bin bin;

    public List(int initialMemory) {
        this.initialMemory = initialMemory;
        head = new Node(initialMemory);
        this.remainingMemory = initialMemory;
        bin = new Bin();
    }

    public void malloc(int x) {
        if (!bin.find(x)) {
            head.setInfo(remainingMemory -= x);
            Node q = new Node(x);
            q.setNext(head.getNext());
            q.setPrevious(head);
            if (q.getNext() != null) {
                q.getNext().setPrevious(q);
            }
            head.setNext(q);
        } else {
            Node p = bin.delete(x);
            Node q, t;
            if (p.getPrevious() != null) {
                q = p.getPrevious();
                q.setNext(p);
            }
            if (p.getNext() != null) {
                t = p.getNext();
                t.setPrevious(p);
            }
        }
        printInfo();
    }

    public void free(int x) {
        Node p;
        p = head.getNext();
        if (p.getInfo() == x) {//if node is next to head node
            remainingMemory += x;
            head.setNext(p.getNext());
            if (p.getNext() != null)
                p.getNext().setPrevious(head);
        } else {
            while (p != null) {
                if (p.getInfo() == x) {
                    p.getPrevious().setNext(p.getNext());
                    if (p.getNext() != null)
                        p.getNext().setPrevious(p.getPrevious());
                    bin.addChunk(p);
                    break;
                }
                p = p.getNext();
            }
            if (p == null)
                System.out.println("Not found!");
        }
        printInfo();
    }

    public void traverse() {
        Node p = head.getNext();
        while (p != null) {
            System.out.print("-" + p.getInfo());
            p = p.getNext();
        }
        System.out.println();
    }

    public void printInfo() {
        System.out.println("Remaining Memory : " + remainingMemory);
        traverse();
        bin.printBin();
        System.out.println("----------------");
    }

}
