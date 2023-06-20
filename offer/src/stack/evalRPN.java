package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class evalRPN {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (String token : tokens) {
                switch (token) {
                    case "+" -> {
                        Integer num1 = stack.pop();
                        Integer num2 = stack.pop();
                        stack.push(num1 + num2);
                    }
                    case "-" -> {
                        Integer num1 = stack.pop();
                        Integer num2 = stack.pop();
                        stack.push(num2 - num1);
                    }
                    case "*" -> {
                        Integer num1 = stack.pop();
                        Integer num2 = stack.pop();
                        stack.push(num1 * num2);
                    }
                    case "/" -> {
                        Integer num1 = stack.pop();
                        Integer num2 = stack.pop();
                        stack.push(num2 / num1);
                    }
                    default -> stack.push(Integer.valueOf(token));
                }
            }
            return stack.pop();
        }
    }
}
