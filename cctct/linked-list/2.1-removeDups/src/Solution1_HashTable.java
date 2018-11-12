import java.util.HashSet;

public class Solution1_HashTable {

    public static void main(String[] args) {
        MyLLNode l_empty = null;
        MyLLNode l_single = new MyLLNode(4);
        MyLLNode l_normal = new MyLLNode(1);

        l_normal.appendToTail(9);
        l_normal.appendToTail(6);
        l_normal.appendToTail(9);

        // print before
        // removeDups
        // print after
        System.out.println("Empty LL");
        System.out.println(l_empty);
        removeDups(l_empty);
        System.out.println(l_empty);

        System.out.println("One element LL");
        System.out.println(l_single);
        removeDups(l_single);
        System.out.println(l_single);

        System.out.println("Normal LL");
        System.out.println(l_normal);
        removeDups(l_normal);
        System.out.println(l_normal);

    }

    private static void removeDups(MyLLNode head) {
        if (head == null) return;
        HashSet<Integer> h = new HashSet<>();
        MyLLNode current = head;
        MyLLNode prev = null;
        while (current != null) {
            if (h.contains(current.data)) prev.next = current.next;
            else {
                h.add(current.data);
                prev = current;
            }
            current = current.next;
        }

    }
}
