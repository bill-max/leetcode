
public class SortedListToBST {
    static class Solution {
        /**
         * 经典分治解决   递归建树  核心问题在于找到链表最中间的一个结点
         * @param head
         * @return
         */
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            return helper(head, null);
        }

        private TreeNode helper(ListNode head, ListNode tail) {
            if (head == tail) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = helper(head, slow);
            root.right = helper(slow.next, tail);
            return root;
        }
    }
}
