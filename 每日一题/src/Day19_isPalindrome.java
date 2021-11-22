import java.util.ArrayDeque;
import java.util.Deque;
public class Day19_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        //创建一个哑结点
        ListNode n=head;
        //创建一个栈
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while(n!=null){
            stack.push(n.val);
            n=n.next;
        }
        while(head.next!=null){
            if(stack.pop()!=head.val){
                return false;
            }else{
                head=head.next;
            }
        }
        return true;
    }
}
