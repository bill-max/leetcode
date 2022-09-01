import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidateStackSequences_946 {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int str1 = 0, str2 = 0;
            for (int i = 0, j = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
