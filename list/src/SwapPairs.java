public class SwapPairs {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode Head = dummyHead;

            while (Head.next != null && Head.next.next != null) {
                ListNode node1 = Head.next;
                ListNode node2 = Head.next.next;
                Head.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                Head = node1;
            }
            return dummyHead.next;
        }
    }
}
