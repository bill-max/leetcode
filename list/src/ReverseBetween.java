public class ReverseBetween {
    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null || left == right) return head;
            ListNode cur = head;
            ListNode node = head;
            ListNode preFa = null;//left的前一个
            //找到需要反转的区域
            int index = 1;
            while (index + 1 != right) {
                if (index + 1 == left) {
                    preFa = node;
                    cur = node.next;
                }
                node = node.next;
                index++;
            }
            ListNode end = node.next.next;//end是right的下一个
            ListNode temp = null;
            ListNode pre = end;
            while (cur != end) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            //处理头和尾
            if (preFa != null)
                preFa.next = pre;
            return left == 1 ? pre : head;
        }

        /**
         * 优化：一次遍历
         *
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween2(ListNode head, int left, int right) {
            // 整个链表的虚拟头节点，以防止left为1的情况
            ListNode dummyHead = new ListNode(0, head);
            // Head为left节点的前驱，以方便进行头插法
            ListNode Head = dummyHead;
            int count = 0;
            // 先找到Head节点
            while(count < left - 1) {
                Head = Head.next;
                count++;
            }
            // 将left到right的节点依次通过头插法插入到Head后面
            ListNode p = Head.next; // p就是当前遍历的节点 left
            ListNode tail = p; // 记录尾节点
            for(int i = left; i < right + 1; i++) {
                ListNode temp = p;
                p = p.next;
                temp.next = Head.next;
                Head.next = temp;
            }
            // 把剩下的不需要反转的接上
            tail.next = p;
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(5);
        head.next = node;
        System.out.println(new Solution().reverseBetween(head, 1, 2));
    }
}
