public class hot_142 {
    public static class Solution {
        /**
         * 快慢指针第二次相遇，一定是在环的入口处
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head==null||head.next==null) return null;
            ListNode fast = head;
            ListNode low = head;
            //第一次相遇
            do {
                if (fast == null || fast.next == null) return null;
                fast = fast.next.next;
                low = low.next;
            } while (fast != low);
            //第二次相遇
            fast = head;
            while (fast != low) {
                fast = fast.next;
                low = low.next;
            }
            return fast;
        }
    }
}
