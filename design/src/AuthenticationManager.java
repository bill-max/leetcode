import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private final int timeToLive;
    private Map<String, Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenMap.containsKey(tokenId)) {
            Integer oriTime = tokenMap.get(tokenId);
            if (currentTime < oriTime + timeToLive) {
                tokenMap.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry entry : tokenMap.entrySet()) {
            if ((Integer)entry.getValue() + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * 使用双向链表存储过期时间顺序
 */
class AuthenticationManager2 {
    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> map;

    public AuthenticationManager2(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<String, Node>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(currentTime + timeToLive, tokenId);
        map.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).expire > currentTime) {
            Node node = map.get(tokenId);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime) {
            Node node = head.next;
            map.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }
        return map.size();
    }
}

class Node {
    int expire;
    String key;
    Node prev;
    Node next;

    public Node(int expire) {
        this(expire, null, null, null);
    }

    public Node(int expire, String key) {
        this(expire, key, null, null);
    }

    public Node(int expire, String key, Node prev, Node next) {
        this.expire = expire;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

