import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    public static class Solution {
        /**
         * 第一种解法   hashset
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }

        /**
         * 第二种解法  双指针  cur1遍历完 listA 之后去遍历 B  cur2 遍历完 B 后去遍历 A
         * 若有环，则必定 cur1 = cur2    因为 length(A)+length(B) = length(B)+length(A)
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode cur1 = headA;
            ListNode cur2 = headB;
            while (cur1 != cur2) {
                cur1 = cur1 == null ? headB : cur1.next;
                cur2 = cur2 == null ? headA : cur2.next;
            }
            return cur1;
        }
    }
}
