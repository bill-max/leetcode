import java.util.ArrayDeque;
import java.util.Deque;

public class NextLargerNodes_1019 {
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Deque<int[]> stack = new ArrayDeque<>();
            int cnt = 0;
            ListNode p = head;
            while (p != null) {
                cnt++;
                p = p.next;
            }

            int[] ans = new int[cnt];
            ListNode node = head;
            int idx = 0, i = 0;
            while (node != null) {
                while (!stack.isEmpty() && node.val > stack.peek()[0]) {
                    int[] pop = stack.pop();
                    ans[pop[1]] = node.val;
                }
                stack.push(new int[]{node.val, idx});
                node = node.next;
                idx++;
            }

            return ans;
        }
    }
}
