public class HasCycle {
    public static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode low = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                low = low.next;
                if (fast == low) {
                    return true;
                }
            }
            return false;
        }
    }
}
