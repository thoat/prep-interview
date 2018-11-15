import java.util.Stack;

public class StackWithMin extends Stack<Integer> { // "extends" as suggested in the CTCI book

    private Stack<Integer> minStack;

    public StackWithMin() {
        minStack = new Stack<>();
    }

    public void push(int i) {
        if (i < min()) minStack.push(i);
        super.push(i); // use of superclass thanks to CTCT's suggestion
    }

    public Integer pop() { // wonder why this doesn't allow return type "int"? Maybe bcz it's overriding Stack's pop() method so the original return type must be honored?
        if (min() == super.pop()) minStack.pop();
        return super.pop();
    }

    public int min() {
        if (minStack.isEmpty()) return Integer.MAX_VALUE; // "MAX_VALUE" as suggested in the CTCI book
        else return minStack.peek();
    }
}
