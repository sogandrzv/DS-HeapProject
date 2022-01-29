public class Bin {
    private LinkedList lists;

    public Bin() {
        lists = new LinkedList();
        for (int i = 0; i < 32; i++) {
            lists.addHeadNode(new Node((i + 1) * 8));
        }
    }

    public void addChunk(Node p) {
        Node t;
        int info = p.getInfo();
        Node q = lists.getFirst();
        while (q != null) {
            if (q.getInfo() == info) {
                t = getRear(q);
                t.setNextBin(p);
                p.setPreviousBin(t);
                return;
            }
            q = q.getNext();
        }
        System.out.println(" ERROR! ");
    }

    public Node getRear(Node head) {//because we should add chunk from last of the list
        Node p = head;
        while (p.getNextBin() != null) {
            p = p.getNextBin();
        }
        return p;
    }

    public void printBin() {
        Node p = lists.getFirst();
        Node q;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            q = p.getNextBin();
            while (q != null) {
                count++;
                q = q.getNextBin();
            }
            if (count != 0) {
                System.out.println("Bin" + (i + 1));
                System.out.println("Chunck size: " + p.getInfo());
                System.out.println("Number of Nodes: " + count);
            }
            p = p.getNext();
        }
    }

    public boolean find(int x) {//for malloc method
        Node p = lists.getFirst();
        while (p != null) {
            if (p.getInfo() == x) {
                if (p.getNextBin() != null)
                    return true;
                return false;
            }
            p = p.getNext();
        }
        System.out.println(" Not found! ");
        return false;
    }

    public Node delete(int x) {
        if (!find(x)) {
            return null;
        }
        Node p = lists.getFirst();
        while (p != null) {
            if (p.getInfo() == x)
                break;
            p = p.getNext();
        }
        Node rear = getRear(p);
        rear.getPreviousBin().setNextBin(null);
        rear.setPreviousBin(null);
        return rear;
    }

}
