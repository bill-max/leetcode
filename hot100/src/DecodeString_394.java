import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeString_394 {
    static class Solution {
        public String decodeString(String s) {
            if (s.length() == 1 && (s.charAt(0) >'z'||s.charAt(0)<'a')) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length();i++) {
                char ch = s.charAt(i);
                if (ch <= 'z' && ch >= 'a') {
                    sb.append(ch);
                    continue;
                }
                int cur = i;
                while (s.charAt(cur) != '[') {
                    cur++;
                }
                int count = Integer.parseInt(s.substring(i, cur));
                Deque<Integer> stack = new ArrayDeque<>();
                int start = cur;
                stack.push(cur);
                while (!stack.isEmpty()) {
                    cur++;
                    if (s.charAt(cur) == '[') {
                        stack.push(cur);
                    } else if (s.charAt(cur) == ']') {
                        start = stack.pop();
                    }
                }
                sb.append(decodeString(s.substring(start + 1, cur)).repeat(count));
                i = cur ;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}
