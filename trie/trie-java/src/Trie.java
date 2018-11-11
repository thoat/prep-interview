import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Trie {

    class TrieNode {
        char key;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isCompleteWord;
        TrieNode parent;
        String prefix;

        TrieNode() {
            isCompleteWord = false;
            parent = null;
            prefix = "";
        }

        TrieNode(char k, boolean complete, TrieNode p) {
            key = k;
            isCompleteWord = complete;
            parent = p;
            prefix = p.prefix + Character.toString(k);
        }
    }

    private TrieNode root;
    private int size;

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    public void insert(String word) {
        insert(word, 0, root);
    }

    private void insert(String word, int i, TrieNode subtrie) {
        if (i >= word.length()) return;

        boolean complete = i == word.length() - 1;
        char k = word.charAt(i);
        TrieNode nextSubtrie = new TrieNode(k, complete, subtrie);
        if (subtrie.children.containsKey(k)) {
            nextSubtrie = subtrie.children.get(k);
            nextSubtrie.isCompleteWord = complete;
        } else {
            subtrie.children.put(k, nextSubtrie);
            size++;
        }
        insert(word, i + 1, nextSubtrie);
    }

    public TrieNode find(String word) {
        return find(word, 0, root);
    }

    private TrieNode find(String word, int i, TrieNode subtrie) {
        if (i < 0 || i >= word.length()) return null;

        char k = word.charAt(i);
        if (!subtrie.children.containsKey(k)) return null;

        subtrie = subtrie.children.get(k);
        if (subtrie.isCompleteWord) return subtrie;
        else return find(word, i + 1, subtrie);
    }

    public boolean delete(String word) {
        if (find(word) == null) return false;

        TrieNode toDelete = find(word);
        while (toDelete != null) {
            if (toDelete.children.size() != 0) {
                toDelete.isCompleteWord = false;
                break;
            } else {
                TrieNode next = toDelete.parent;
                next.children.remove(toDelete.key);
                size--;
                toDelete = next;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        /* note: must pass TrieNode type into Queue's generic, else q.poll() will return an (invalid) generic Object */
        TrieNode current = root;
        Queue<TrieNode> q = new LinkedList<>(current.children.values());
        while (!q.isEmpty()) {
            current = q.poll();
            if (current.isCompleteWord) {
                result.append(current.prefix);
                result.append(q.isEmpty() ? "" : ", ");
            }
            q.addAll(current.children.values());
        }
        return result.toString();
    }
}
