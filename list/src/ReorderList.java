public class ReorderList {
    static class Solution {
        /**
         * 找到链表中点  +  翻转链表  +  合并链表
         *
         * @param head
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode mid = getMiddleNode(head);
            //分割链表
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverseList(l2);
            mergeList(l1, l2);
        }

        //找到链表中点  的上一个结点
        private ListNode getMiddleNode(ListNode head) {
            ListNode fast = head;
            ListNode low = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
            return low;
        }

        //翻转链表
        private ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode temp = null;
            ListNode pre = null;
            while (cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        //合并链表
        private void mergeList(ListNode l1, ListNode l2) {
            ListNode temp1 = null;
            ListNode temp2 = null;
            while (l1 != null && l2 != null) {
                temp1 = l1.next;
                temp2 = l2.next;

                l1.next = l2;
                l1 = temp1;

                l2.next = l1;
                l2 = temp2;
            }
        }
    }
}
