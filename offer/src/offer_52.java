
public class offer_52 {
    static class Solution {
        /**
         * 找两个链表的公共结点
         * @param headA
         * @param headB
         * @return
         */
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
    }
}
