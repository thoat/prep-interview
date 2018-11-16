public class AnimalShelterDemo {

    private static final Animal DOG1 = new Dog();
    private static final Animal CAT3 = new Cat();
    private static final Animal DOG4 = new Dog();
    private static final Animal CAT2 = new Cat();
    private static final Animal CAT5 = new Cat();
    private static final Animal CAT6 = new Cat();
    private static final Animal CAT7 = new Cat();
    private static final Animal DOG8 = new Dog();

    public static void main(String[] args) {
        AnimalShelter myShelter = new AnimalShelter();
        testEnqueue(myShelter);
        testDequeueAny(myShelter, false);
        testDequeueDog(myShelter);
        testDequeueCat(myShelter);

//        AnimalShelter emptyShelter = new AnimalShelter();
//        testDequeueAny(emptyShelter, true);
    }

    private static void checkEquals(Object expected, Object actual, String testType) {
        if (expected.equals(actual)) {
            System.out.println(testType + ": test passed.");
        } else {
            System.out.println(testType + ": test failed. "
                    + "Expect " + expected + " but got " + actual);
        }
    }

    private static void testEnqueue(AnimalShelter s) {
        s.enqueue(DOG1);
        s.enqueue(CAT2);
        s.enqueue(CAT3);
        s.enqueue(DOG4);
        s.enqueue(CAT5);
        s.enqueue(CAT6);
        s.enqueue(CAT7);
        s.enqueue(DOG8);
        String actual = s.toString();
        StringBuilder expected = new StringBuilder();
        expected.append("Dogs are:\n");
        expected.append(DOG1.toString());
        expected.append(DOG4.toString());
        expected.append(DOG8.toString());
        expected.append("Cats are:\n");
        expected.append(CAT2.toString());
        expected.append(CAT3.toString());
        expected.append(CAT5.toString());
        expected.append(CAT6.toString());
        expected.append(CAT7.toString());
        checkEquals(expected.toString(), actual, "enqueue");
    }

    private static void testDequeueAny(AnimalShelter s, boolean isEmpty) {
//         TODO: check for exception thrown. Maybe use assert in JUnit?
//        if (isEmpty) checkEquals(NullPointerException, s.dequeueAny(), "dequeueAny-on-empty");
        if (!isEmpty) checkEquals(DOG1, s.dequeueAny(), "dequeueAny-on-normal");
    }

    private static void testDequeueDog(AnimalShelter s) {
        checkEquals(DOG4, s.dequeueDog(), "dequeueDog");
    }

    private static void testDequeueCat(AnimalShelter s) {
        checkEquals(CAT2, s.dequeueCat(), "dequeueCat");
    }

}
