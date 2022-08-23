import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
                if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty()) return false;
                    Character c = stack.pop();
                    if (!map.get(ch).equals(c)) return false;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }
}
