import java.util.Deque;
import java.util.LinkedList;

public class offer_31 {
    static class Solution {
        /**
         * 简单题 ： 利用栈模拟弹出 压入过程即可
         * @param pushed int[] push
         * @param popped int[] pop
         * @return boolean
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new LinkedList<>();
            int p1 = 0;
            int p2 = 0;
            while (p1 < pushed.length) {
                stack.push(pushed[p1]);
                while (!stack.isEmpty() && stack.peek().equals(popped[p2])) {
                    stack.pop();
                    p2++;
                }
                p1++;
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
