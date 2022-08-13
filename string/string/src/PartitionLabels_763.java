import java.util.*;

@SuppressWarnings("ALL")
public class PartitionLabels_763 {
    /*
    "ababcbaca defegdehijhklij"
      a
      a | b
      a b a
      a b a b
      a b a b | c
     */
    static class Solution {
        public List<Integer> partitionLabels(String s) {
            if (s.length() == 1) return new ArrayList<Integer>() {{
                add(1);
            }};

            List<Integer> ans = new ArrayList<>();

            Map<Character, Integer[]> map = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new Integer[]{i, i});
                } else {
                    map.get(c)[1] = i;
                }
            }

            //合并区间
            int l = 0, r = 0;
            while (r < s.length() && l < s.length()) {
                char c1 = s.charAt(l);
                r = map.get(c1)[1];
                int temp = r + 1;
                while (temp < s.length()) {
                    char c2 = s.charAt(temp);
                    if (map.get(c2)[0] < r && map.get(c2)[0] > l) {
                        r = map.get(s.charAt(temp))[1];
                        temp = r + 1;
                    } else
                        temp++;
                }
                ans.add(r - l + 1);
                l = r + 1;
            }

            return ans;
        }
    }
    static class Solution2 {
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<Integer>();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("aaaabccb"));
    }
}
