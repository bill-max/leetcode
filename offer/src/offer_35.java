import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class offer_35 {
    static class Solution {
        /**
         * 哈希表
         * 核心思想：
         * 第一遍遍历，储存并新建列表的所有结点
         * 第二遍遍历，构建列表
         * O(n)  O(n)
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node cur = head;
            Map<Node, Node> map = new HashMap<>();
            // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while(cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            // 4. 构建新链表的 next 和 random 指向
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 5. 返回新链表的头节点
            return map.get(head);
        }

        /**
         * 拼接+拆分
         * 核心思想：
         * 在原有列表的结点后直接复制一个新结点；这样就可以在按照顺序遍历的同时构建random
         *
         * @param head
         * @return
         */
        public Node copyRandomList2(Node head) {
            if (head==null) return null;
            Node cur = head;
            //1. 复制各结点，建立拼接链表
            while (cur != null) {
                Node temp = new Node(cur.val);
                temp.next = cur.next;
                cur.next = temp;
                cur = temp.next;
            }
            //2. 各结点建立random
            cur = head;
            while (cur != null) {
                Node aim = cur.next;//cur的下一个是复制的结点，一定不为null
                if (cur.random != null) {
                    aim.random = cur.random.next;
                }
                cur = aim.next;
            }
            //3. 将新建的列表拆分出来
            cur = head.next;
            Node pre = head, res = head.next;
            while(cur.next != null) {
                pre.next = pre.next.next;//原结点 拆分
                cur.next = cur.next.next;//新结点 拆分
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null; // 单独处理原链表尾节点
            return res;      // 返回新链表头节点
        }

    }
}
