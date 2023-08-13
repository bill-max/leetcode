import java.util.HashMap;
import java.util.Map;

public class MagicDictionary {
    class Tire {
        Map<Character, Tire> children;
        boolean isEnd;

        public Tire() {
            children = new HashMap<Character, Tire>();
            isEnd = false;
        }

        public void add(String s) {
            Tire node = this;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!node.children.containsKey(ch)) node.children.put(ch, new Tire());
                node = node.children.get(ch);
            }
            node.isEnd = true;
        }

    }

    Tire root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new Tire();
    }

    public void buildDict(String[] dictionary) {
        for (String key : dictionary) {
            root.add(key);
        }
    }

    private boolean dfs(Tire node, String word, int idx, boolean mod) {
        if (word.length() == idx) return node.isEnd && mod;
        char c = word.charAt(idx);
        if (node.children.containsKey(c)) {
            if (dfs(node.children.get(c), word, idx + 1, mod)) return true;
        }
        if (!mod) {
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                if (ch!=word.charAt(idx) && node.children.containsKey(ch) && dfs(node.children.get(ch), word, idx + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, false);
    }
}
