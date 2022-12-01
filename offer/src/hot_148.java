public class hot_148 {
    static class Solution {
        /**
         * 对链表用归并排序
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            return mergeSort(head, null);
        }

        private ListNode mergeSort(ListNode head, ListNode tail) {
            if (head == null) return head;
            //将链表拆分
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            //使用快慢指针将链表拆分
            ListNode fast = head;
            ListNode low = head;
            while (fast != tail) {
                fast = fast.next;
                low = low.next;
                //防止链表长度为奇数
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            //分治
            ListNode mid = low;
            ListNode list1 = mergeSort(head, mid);
            ListNode list2 = mergeSort(mid, tail);
            //归并
            ListNode sorted = merge(list1, list2);
            return sorted;
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            ListNode node1 = list1;
            ListNode node2 = list2;
            ListNode dummpyHead = new ListNode(0);
            ListNode node = dummpyHead;
            while (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    node.next = node1;
                    node1 = node1.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                }
                node = node.next;
            }
            if (node1 != null) {
                node.next = node1;
            }
            if (node2 != null) {
                node.next = node2;
            }
            return dummpyHead.next;
        }
    }
}
