public class offer_22 {
    static class Solution {
        /**
         * 二次遍历
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            int cur = 0;
            ListNode node = head;
            while (node != null) {
                cur++;
                node = node.next;
            }
            for (int i = 0; head != null; head = head.next, i++) {
                if (i == cur - k + 1) {
                    return head;
                }
            }
            return null;
        }

        /**
         * 双指针优化   经典快慢指针
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd2(ListNode head, int k) {
            ListNode pre=head;
            ListNode post = head;
            for (int i = 0; i < k; i++) {
                post = post.next;
            }
            while (post != null) {
                pre = pre.next;
                post = post.next;
            }
            return pre;
        }
    }

    public static void main(String[] args) {

    }
}
