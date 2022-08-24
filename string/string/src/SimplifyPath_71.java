import java.util.Stack;

public class SimplifyPath_71 {
    static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < path.length()&&path.charAt(i)=='/') i++;
            while (i < path.length()) {
                int end = i;
                while (end < path.length() && path.charAt(end) != '/')
                    end++;
                String s = path.substring(i, end );
                while (end < path.length() && path.charAt(end) == '/') end++;
                i = end;

                if (s.equals("."));
                else if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                    stack.push("/");
                }
            }


            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            sb.insert(0, '/');
            if (sb.length() != 1) {
                return sb.substring(0, sb.length() - 1);
            } else
                return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c"));
    }
}
