import java.lang.reflect.Array;
import java.util.*;

public class RemoveSubfolders_1233 {
    static class Solution {
        /**
         * 排序
         */
        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder, Comparator.comparingInt(String::length));
            Set<String> set = new HashSet<>();
            List<String> ans = new ArrayList<>();
            for (String s : folder) {
                String[] split = s.split("/");
                StringBuilder sb = new StringBuilder();
                boolean contains = false;
                for (String s1 : split) {
                    if (Objects.equals(s1, "") || null == s1) continue;
                    sb.append("/").append(s1);
                    if (set.contains(sb.toString())) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    set.add(s);
                    ans.add(s);
                }
            }
            return ans;
        }

        /**
         * 排序改进版 按照字典序排序，只需要比较长度即可
         */
        public List<String> removeSubfolders2(String[] folder) {
            Arrays.sort(folder);
            List<String> ans = new ArrayList<String>();
            ans.add(folder[0]);
            for (int i = 1; i < folder.length; ++i) {
                int pre = ans.get(ans.size() - 1).length();
                if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                    ans.add(folder[i]);
                }
            }
            return ans;
        }
    }

    /**
     * 字典树
     */
    static class Solution2 {
        public List<String> removeSubfolders(String[] folder) {
            //构建字典树
            Trie root = new Trie();
            for (int i = 0; i < folder.length; ++i) {
                List<String> path = split(folder[i]);
                Trie cur = root;
                for (String name : path) {
                    cur.children.putIfAbsent(name, new Trie());
                    cur = cur.children.get(name);
                }
                cur.ref = i;
            }

            List<String> ans = new ArrayList<String>();
            dfs(folder, ans, root);
            return ans;
        }

        public List<String> split(String s) {
            List<String> ret = new ArrayList<String>();
            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch == '/') {
                    ret.add(cur.toString());
                    cur.setLength(0);
                } else {
                    cur.append(ch);
                }
            }
            ret.add(cur.toString());
            return ret;
        }

        public void dfs(String[] folder, List<String> ans, Trie cur) {
            if (cur.ref != -1) {
                ans.add(folder[cur.ref]);
                return;
            }
            for (Trie child : cur.children.values()) {
                dfs(folder, ans, child);
            }
        }
    }

    static class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            ref = -1;
            children = new HashMap<String, Trie>();
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }
}
