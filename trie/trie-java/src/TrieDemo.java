public class TrieDemo {

    public static void main(String[] args) {
        Trie myTrie = new Trie();
        testInsert(myTrie);
//         testFind(myTrie);
        testDelete(myTrie);
    }

    private static void testInsert(Trie t) {
        t.insert("Thoa");
        t.insert("Thien");
        t.insert("Thang");
        t.insert("Thi");
        t.insert("Van");

        String expected = "Thi, Van, Thoa, Thang, Thien";
        String actual = t.toString();
        checkEquals(expected, actual, "insert");
    }

    private static void testFind(Trie t) {
        // case 1: search for an existing complete word
        checkEquals(true, t.find("Thoa"), "find-valid");
        // case 2: search for an existing but incomplete string
        checkEquals(null, t.find("Tho"), "find-incomplete");
        // case 3: search for a non-existing word
        checkEquals(null, t.find("Thong"), "find-donotexist");
        // case 4: search for a nested complete word
        checkEquals(true, t.find("Thi"), "find-valid-nested");
    }

    private static void testDelete(Trie t) {
        // case 1: delete an existing complete word
        t.delete("Thoa");
        checkEquals("Thi, Van, Thang, Thien", t.toString(), "delete-valid");
        // case 2: delete an existing but incomplete string
        t.delete("Than");
        checkEquals("Thi, Van, Thang, Thien", t.toString(), "delete-invalid");
        // case 3: delete an existing complete but nested word
        t.delete("Thi");
        checkEquals("Van, Thang, Thien", t.toString(), "delete-valid-nested");
    }

    private static void checkEquals(Object expected, Object actual, String testType) {
        if (expected.equals(actual)) {
            System.out.println("Test passed: " + testType);
        } else {
            System.out.println("Test failed: " + testType);
            System.out.println("--- Expected: " + expected + "; Actual: " + actual);
        }
    }
}
