public class MergeTwoLists {
    static class Solution {
        /**
         * 合并两个有序链表
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1==null) return list2;
            else if (list2==null) return list1;
            if (list1.val > list2.val) {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            } else {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
        }
    }
}
