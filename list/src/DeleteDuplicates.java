public class DeleteDuplicates {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    ListNode temp = node.next;
                    while (temp != null && temp.val == node.val) {
                        temp = temp.next;
                    }
                    node.next = temp;
                }
                node = node.next;
            }
            return head;
        }
    }
}
