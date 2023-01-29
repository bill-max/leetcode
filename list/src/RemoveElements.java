public class RemoveElements {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1, head);

            ListNode pre = dummyHead;
            while (pre != null && pre.next != null) {
                if (pre.next.val == val)
                    pre.next = pre.next.next;
                else
                    pre = pre.next;
            }
            return dummyHead.next;
        }
    }
}
