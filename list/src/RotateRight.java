public class RotateRight {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null) {
                return head;
            }
            //统计链表节点个数
            int n = 1;
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                n++;
            }
            //计算旋转个数
            int add = n - k % n;
            if (add == n) {
                return head;
            }
            //将链表转为环
            iter.next = head;
            while (add-- > 0) {
                iter = iter.next;
            }
            //找到断开位置
            ListNode ret = iter.next;
            iter.next = null;
            return ret;
        }
    }
}
