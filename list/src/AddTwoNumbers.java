public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1=0;
        ListNode one=l1;
        ListNode two=l2;
        int n2=0;
        while (one != null) {
            n1++;
            one = one.next;
        }
        while (two != null) {
            n2++;
            two = two.next;
        }
        if (n1 >= n2) {
            help(l1, l2);
            return l1;
        } else {
            help(l2, l1);
            return l2;
        }
    }

    public void help(ListNode l1, ListNode l2) {
        //确定递归边界，默认l2长度小于等于l1
        if (l1 == null) {
            return;
        }
        if (l2 != null) {
            l1.val += l2.val;
        }
        if (l1.val>=10){
            l1.val= l1.val%10;
            if (l1.next == null) {
                l1.next=new ListNode(1);
            }else {
                l1.next.val++;
            }
        }
        if (l2 == null) {
            help(l1.next, null);
        } else {
            help(l1.next,l2.next);
        }
    }
}
