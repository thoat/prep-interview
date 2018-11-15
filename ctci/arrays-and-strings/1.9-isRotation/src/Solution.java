public class Solution {

    public static void main(String[] args) {
        checkEquals("different-lens", false, isRotation("waterbottle", "water"));
        checkEquals("empty-strings", false, isRotation("", ""));
        checkEquals("valid", true, isRotation("waterbottle", "erbottlewat"));
        checkEquals("invalid", false, isRotation("waterbottle", "erbottleeul"));
    }

    private static void checkEquals(String testType, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testType + ":\t\tTest passed");
        } else {
            System.out.println(testType + ":\t\tTest failed. Expected: " + expected + ", actual: " + actual);
        }
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return false;
        String s1s1 = s1 + s1;
        return isSubstring(s2, s1s1);
    }

    private static boolean isSubstring(String small, String large) {
        int starting_i = 0;
        // try to find the starting point of "small" in "large"
        while (small.charAt(0) != large.charAt(starting_i) && starting_i < large.length()) {
            starting_i++;
        }
        if (starting_i >= large.length()) return false; // out of scope
        if (large.length() - starting_i < small.length()) return false; // remaining string is too short
        int i_sm = 0;
        while (i_sm < small.length()) {
            if (small.charAt(i_sm) != large.charAt(starting_i + i_sm)) return false;
            i_sm++;
        }
        return true;
    }

}
