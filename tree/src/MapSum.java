import java.util.Map;

public class MapSum {

    private Tire tree;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        tree = new Tire();
    }

    public void insert(String key, int val) {
        tree.add(key, val);
    }

    public int sum(String prefix) {
        return add(prefix, 0, tree);
    }

    private int add(String pre, int cur, Tire node) {
        if (cur < pre.length()) {
            int index = pre.charAt(cur) - 'a';
            if (node.chiledren[index] != null)
                return add(pre, cur + 1, node.chiledren[index]);
            else
                return 0;
        }
        int sum = node.value;
        for (int i = 0; i < 26; i++) {
            if (node.chiledren[i] != null) sum += add(pre, cur, node.chiledren[i]);
        }
        return sum;
    }

}

class Tire {
    Tire[] chiledren;
    int value;

    public Tire() {
        this.value = 0;
        chiledren = new Tire[26];
    }

    public void add(String key, int value) {
        Tire node = this;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.chiledren[index] == null) node.chiledren[index] = new Tire();
            node = node.chiledren[index];
        }
        node.value = value;
    }

}
