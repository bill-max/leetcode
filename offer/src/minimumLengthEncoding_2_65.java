import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class minimumLengthEncoding_2_65 {
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            Tire tree = new Tire();
            for (String word : words) {
                tree.add(word);
            }
            AtomicInteger ans = new AtomicInteger();
            Arrays.stream(words).distinct().forEach(s -> {
                if (!tree.startWith(s)) {
                    ans.addAndGet(s.length() + 1);
                }
            });
            return ans.get();
        }
    }

    class Tire {
        Tire[] children;
        boolean isEnd;

        public Tire() {
            children = new Tire[26];
            isEnd = false;
        }

        public void add(String s) {
            Tire node = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if (node.children[idx] == null) node.children[idx] = new Tire();
                node = node.children[idx];
            }
            isEnd = true;
        }

        public boolean startWith(String prefix) {
            Tire node = this;
            for (int i = prefix.length() - 1; i >= 0; i--) {
                int idx = prefix.charAt(i) - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    return true;
                }
            }
            return false;
        }
    }
}
