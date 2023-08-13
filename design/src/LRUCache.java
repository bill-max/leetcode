import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLN {
        int key;
        int value;
        DLN pre;
        DLN next;

        public DLN() {
        }

        public DLN(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private final Map<Integer, DLN> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLN head;
    private DLN tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLN();
        tail = new DLN();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLN node = cache.get(key);
        if (node == null) return -1;
        move2Head(node);
        return node.value;
    }

    private void move2Head(DLN node) {
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(DLN node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLN node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        DLN node = cache.get(key);
        if (node == null) {
            DLN n = new DLN(key, value);
            add2Head(n);
            cache.put(key, n);
            ++size;
            if (size > capacity) {
                DLN tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            move2Head(node);
        }
    }

    private DLN removeTail() {
        DLN pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}
