import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day19_hasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;

    }
}
