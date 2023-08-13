import java.util.ArrayDeque;
import java.util.Deque;

public class minLength {
    class Solution {
        public int minLength(String s) {
            Deque<Character> stack = new ArrayDeque<Character>();
            for (int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if (c == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                    stack.poll();
                } else if (c == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                    stack.poll();
                } else {
                    stack.push(c);
                }
            }
            return stack.size();
        }
    }
}
