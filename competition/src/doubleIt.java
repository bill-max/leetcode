import java.util.Deque;
import java.util.List;

public class doubleIt {
    public ListNode doubleIt(ListNode head) {
        ListNode root = reverse(head);
        int tmp = 0;
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while (root != null) {
            tmp += root.val * 2;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            root = root.next;
            tmp /= 10;
        }
        if (tmp > 0) {
            cur.next = new ListNode(tmp);
        }
        return reverse(node.next);
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        ListNode head = cur;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(9);
        ListNode n2 = new ListNode(8, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode res = new doubleIt().doubleIt(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
