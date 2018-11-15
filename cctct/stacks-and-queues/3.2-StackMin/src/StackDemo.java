public class StackDemo {

    public static void main(String[] args) throws Exception {
        StackWithMin s = new StackWithMin();

        s.push(13);
        s.push(10);
        s.push(7);
        s.push(5);
        s.push(9);
        s.push(4);

        checkEquals(4, s.min(), "min-on-normal");
        checkEquals(4, s.pop(), "pop-on-normal");
        checkEquals(5, s.min(), "min-after-last-min-removed");
    }

    private static void checkEquals(Object expected, Object actual, String testType) {
        if (expected.equals(actual)) {
            System.out.println(testType + ": test passed.");
        } else {
            System.out.println(testType + ": test failed. Expect " + expected + " but actual is " + actual);
        }
    }

}
