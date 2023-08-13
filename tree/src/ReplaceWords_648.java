import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReplaceWords_648 {
    class Solution {
        class Trie {
            boolean isEnd;
            Trie[] children = new Trie[26];
        }

        Trie root = new Trie();

        void add(String s) {
            Trie p = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (p.children[idx] == null) p.children[idx] = new Trie();
                p = p.children[idx];
            }
            p.isEnd = true;
        }

        String findPrev(String s) {
            Trie p = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (p.children[idx] == null) break;
                if (p.children[idx].isEnd) return s.substring(0, i + 1);
                p = p.children[idx];
            }
            return s;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            for (String word : dictionary) {
                add(word);
            }
            StringBuilder sb = new StringBuilder();
            for (String word : sentence.split(" ")) {
                sb.append(findPrev(word)).append(" ");
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
}
