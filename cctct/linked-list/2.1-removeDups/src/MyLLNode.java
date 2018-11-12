import java.util.ArrayList;

public class MyLLNode {

    int data;
    MyLLNode next = null;

    MyLLNode() { }

    MyLLNode(int d) {
        data = d;
    }
    void appendToTail(int d) {
        MyLLNode newNode = new MyLLNode(d);
        MyLLNode current = this; // NOTE!
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public String toString() {
        ArrayList<Integer> a = new ArrayList<>();
        MyLLNode current = this; // NOTE!
        while (current != null) {
            a.add(current.data);
            current = current.next;
        }
        return a.toString();
    }
}
