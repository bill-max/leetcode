import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindReplaceString_833 {
    static class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < indices.length; i++) {
                map.put(indices[i], i);
            }

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                if (map.containsKey(i)) {
                    int idx = map.get(i);
                    String str = sources[idx];
                    int end = Math.min(i + str.length(), s.length());
                    if (s.substring(i, end).equals(str))
                        sb.append(targets[idx]);
                    else
                        sb.append(s, i, end);
                    i = Math.min(i + str.length(), s.length());
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}));
    }
}
