public class DetectCycle {
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode low = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                low = low.next;
                if (fast == low) {
                    break;
                }
            }
            if (fast==null||fast.next==null) return null;
            fast = head;
            while (fast != low) {
                fast = fast.next;
                low = low.next;
            }
            return fast;
        }
    }
}
