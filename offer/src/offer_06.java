import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class offer_06 {
    static class Solution {
        /**
         * api
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            List<Integer> ans = new ArrayList<>();
            while (head != null) {
                ans.add(head.val);
                head = head.next;
            }
            Collections.reverse(ans);
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        int[] res;
        int i=0, j = 0;
        public int[] reversePrint2(ListNode head) {
            help(head);
            return res;
        }

        public void help(ListNode node) {
            if (node == null) {
                res = new int[i];
                return;
            }
            i++;
            help(node.next);
            res[j++] = node.val;
        }
    }

    public static void main(String[] args) {
    }
}
