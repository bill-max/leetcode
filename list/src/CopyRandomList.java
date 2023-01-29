import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    static class Solution {
        /**
         * 使用map 映射新旧结点
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            if(head==null) return null;
            Map<Node, Node> map = new HashMap<>();
            //第一个循环，创建新旧结点的映射
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            //依次构建结点
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }

            return map.get(head);
        }
    }
}
