import java.util.*;

public class offer_30 {
    static class MinStack {
        /**
         * 使用辅助栈，让插入、删除以及寻找最小值都是 O(1)
         * 具体做法：每次stack push的时候都往 minStack push当前的最小值
         * 弹出的时候，两个栈一起弹出，可以保证所有操作同步
         *
         * 核心思想： 保持辅助栈的非严格降序
         */
        private final Deque<Integer> minStack;
        private final Deque<Integer> stack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
            stack = new LinkedList<>();
        }

        public void push(int x) {
            assert !minStack.isEmpty();
            minStack.push(Math.min(x, minStack.peek()));
            stack.push(x);
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int min() {
            assert !minStack.isEmpty();
            return minStack.peek();
        }
    }
}
