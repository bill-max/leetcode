import java.util.ArrayDeque;
import java.util.Deque;


public class ScoreOfParentheses_856 {
    static class Solution {
        public int scoreOfParentheses(String s) {
            Deque<Integer> st = new ArrayDeque<>();
            st.push(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(0);
                } else {
                    int v = st.pop();
                    int top = st.pop() + Math.max(2 * v, 1);
                    st.push(top);
                }
            }
            return st.peek();
        }
    }

    public static void main(String[] args) {

    }
}
