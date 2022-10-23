public class offer_18 {
    static class Solution {
        /**
         * 删除链表节点 常规题
         * @param head
         * @param val
         * @return
         */
        public ListNode deleteNode(ListNode head, int val) {
            ListNode nodeStart = head;
            if (nodeStart.val == val) {
                return head.next;
            }
            ListNode node = head.next;
            while (node != null) {
                if (node.val == val) {
                    nodeStart.next = node.next;
                }
                nodeStart = node;
                node = node.next;
            }
            return head;
        }

    }

    public static void main(String[] args) {

    }
}
