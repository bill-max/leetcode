import com.sun.org.apache.bcel.internal.generic.DUP;

public class MergeInBetween_1669 {
    static class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            int count = 0;
            ListNode headA = new ListNode();
            ListNode node = list1;
            while (count != b) {
                if (count == a - 1) {
                    headA = node;
                }
                node = node.next;
                count++;
            }
            ListNode head2 = new ListNode();
            head2.next = list2;
            while (head2.next != null) {
                head2 = head2.next;
            }
            headA.next = list2;
            head2.next = node.next;
            return list1;
        }
    }

    public static void main(String[] args) {

    }
}
