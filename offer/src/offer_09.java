import java.util.ArrayDeque;
import java.util.Deque;

public class offer_09 {
    static class CQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public CQueue() {
            inStack = new ArrayDeque<Integer>();
            outStack = new ArrayDeque<Integer>();
        }

        public void appendTail(int value) {
            inStack.push(value);

        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) {
                    return -1;
                }
                in2out();
            }
            return outStack.pop();
        }
        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {

    }
}
