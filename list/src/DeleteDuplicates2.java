public class DeleteDuplicates2 {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode node = dummyHead;
            ListNode cur = node.next;
            while (node.next != null) {
                int count = 0;
                while (cur.next != null && cur.val == cur.next.val) {
                    count++;
                    cur = cur.next;
                }
                if (count >= 1) {
                    node.next = cur.next;
                } else {
                    node = node.next;
                }
                cur = node.next;
            }
            return dummyHead.next;
        }
    }
}
