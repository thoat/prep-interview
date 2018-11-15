/* Let assume we're building a COMPLETE binary tree */
class BTNode {
    public String value;
    public BTNode left;
    public BTNode right;

    public BTNode(String v) {
        value = v;
    }

    public void insert(String item) {
        insert(item, this);
    }

    private void insert(String item, BTNode root) {
        if (root.left == null) root.left = new BTNode(item);
        else if (root.right == null) {
            root.right = new BTNode(item);
        } else if (root.left.left == null || root.left.right == null)
            insert(item, root.left);
        else insert(item, root.right);
    }
}

public class BinaryTreeTraversalDemo {

    private static final String IN_ORDER = "in-order";
    private static final String PRE_ORDER = "pre-order";
    private static final String POST_ORDER = "post-order";

    public static void main(String[] args) {

        BTNode t = new BTNode("A");
        t.insert("B");
        t.insert("C");
        t.insert("D");
        t.insert("E");
        t.insert("F");
        t.insert("G");
        t.insert("H");
        traverse(t, IN_ORDER);
        traverse(t, PRE_ORDER);
        traverse(t, POST_ORDER);
        System.out.println("My tree is:");
        System.out.println("        A");
        System.out.println("     /      \\");
        System.out.println("    B         C");
        System.out.println("   /   \\     /  \\");
        System.out.println("  D    E    F    G");
        System.out.println(" /");
        System.out.println("H");

    }

    private static void traverse(BTNode root, String type) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case IN_ORDER:
                inOrderTraversal(root, sb);
                break;
            case PRE_ORDER:
                preOrderTraversal(root, sb);
                break;
            case POST_ORDER:
                postOrderTraversal(root, sb);
                break;
        }
        System.out.println("Traverse " + type + ": " + sb);
    }

    /* left, root, right */
    /* This implementation assumes the very first root passed in is never null */
    private static void inOrderTraversal(BTNode root, StringBuilder sb) {
        if (root.left != null) inOrderTraversal(root.left, sb);
        sb.append(root.value);
        sb.append(" ");
        if (root.right != null) inOrderTraversal(root.right, sb);
    }

    /* root, left, right */
    /* This implementation assumes the very first root passed in is never null */
    private static void preOrderTraversal(BTNode root, StringBuilder sb) {
        sb.append(root.value);
        sb.append(" ");
        if (root.left != null) preOrderTraversal(root.left, sb);
        if (root.right != null) preOrderTraversal(root.right, sb);
    }

    /* left, right, root */
    /* This implementation assumes the very first root passed in is never null */
    private static void postOrderTraversal(BTNode root, StringBuilder sb) {
        if (root.left != null) postOrderTraversal(root.left, sb);
        if (root.right != null) postOrderTraversal(root.right, sb);
        sb.append(root.value);
        sb.append(" ");
    }
}
