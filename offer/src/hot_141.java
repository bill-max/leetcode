import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hot_141 {
    public static class Solution {
        /**
         * 快慢指针
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if (head==null||head.next==null) return false;
            ListNode fast = head.next;
            ListNode low = head;
            while (fast!=low) {
                if (fast==null||fast.next==null) return false;
                fast = fast.next.next;
                low = low.next;
            }
            return true;
        }
    }
}
