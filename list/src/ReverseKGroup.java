public class ReverseKGroup {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) return head;
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode node = head;
            int count = 0;
            while (node != null) {
                count++;
                node = node.next;
            }
            ListNode Head = dummyHead;
            ListNode p = Head.next;
            ListNode tail = p;
            while (count >= k) {
                for (int i = 0; i < k; i++) {
                    ListNode temp = p;
                    p = p.next;
                    temp.next = Head.next;
                    Head.next = temp;
                }
                tail.next = p;
                Head = tail;
                tail = p;
                count -= k;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = newNode(1);
        System.out.println(new Solution().reverseKGroup(head,2));
    }

    private static ListNode newNode(int i) {
        if (i == 7) return null;
        ListNode node = new ListNode(i);
        node.next = newNode(i + 1);
        return node;
    }
}
