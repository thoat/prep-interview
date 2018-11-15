import java.util.HashSet;

public class Solution1_HashTable {

    final static int CHARACTER_SET_SIZE = 26; // can be 26 or 128 or whatever

    public static void main(String[] args) {

        checkEquals("empty-string", true, isUniqueChars(""));
        checkEquals("single-char-string", true, isUniqueChars("b"));
        checkEquals("valid-string", true, isUniqueChars("baghe"));
        checkEquals("invalid-string", false, isUniqueChars("bagha"));
        checkEquals("too-long-string", false, isUniqueChars("abcdefghijklmnopqrstuvwxyza"));
    }

    private static void checkEquals(String testType, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testType + ":\t\tTest passed");
        } else {
            System.out.println(testType + ":\t\tTest failed. Expected: " + expected + ", actual: " + actual);
        }
    }

    private static boolean isUniqueChars(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return true;
        if (n == 2) return s.charAt(0) == s.charAt(1);
        if (n > CHARACTER_SET_SIZE) return false;

        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (h.contains(c)) return false;
            h.add(c);
        }
        return true;
    }
}
