public class Partition {
    static class Solution {
        /**
         * 两次遍历   直接在原链表上修改
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition(ListNode head, int x) {
            if (head == null) return null;
            ListNode tail = head;
            int count = 1;
            while (tail.next != null) {
                count++;
                tail = tail.next;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode cur = dummyHead;
            for (int i = 0; i < count; i++) {
                if (cur.next.val >= x) {
                    tail.next = cur.next;
                    cur.next = cur.next.next;

                    tail = tail.next;
                    tail.next = null;
                } else
                    cur = cur.next;
            }

            return dummyHead.next;
        }

        /**
         * 一次遍历， 但需要维护额外的链表结点
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition2(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }

    }
}

