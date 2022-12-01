import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    static class Solution {
        /**
         * 直接调用合并两个链表的方法
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length <= 1) return lists[0];
            ListNode list = lists[0];
            for (int i = 1; i < lists.length; i++) {
                list = mergeTwoLists(list, lists[i]);
            }
            return list;
        }

        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            else if (list2 == null) return list1;
            if (list1.val > list2.val) {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            } else {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
        }

        /**
         * 使用
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists2(ListNode[] lists) {
            Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode node : lists) {
                if (node != null) {
                    heap.offer(node);
                }
            }
            ListNode head = new ListNode();
            ListNode tail = head;
            while (!heap.isEmpty()) {
                ListNode cur = heap.poll();
                tail.next = cur;
                tail = tail.next;
                if (cur.next != null) {
                    heap.offer(cur.next);
                }
            }
            return head.next;
        }
    }
}
