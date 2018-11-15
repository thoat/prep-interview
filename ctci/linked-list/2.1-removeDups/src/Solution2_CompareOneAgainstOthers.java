public class Solution2_CompareOneAgainstOthers {

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
        if (head == null || head.next == null) return; // if 0 or 1 element, no dups to remove
        MyLLNode p1 = head, p2, prev;
        while (p1 != null) {
            p2 = p1.next;
            prev = p1;
            while (p2 != null) {
                if (p2.data == p1.data) {
                    prev.next = p2.next;
                } else {
                    prev = p2;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }

    }
}
