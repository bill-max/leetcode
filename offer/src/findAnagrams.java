import java.util.*;

public class findAnagrams {
    static class Solution {

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) return ans;

            int[] pCnt = new int[26];
            int[] sCnt = new int[26];
            for (int i = 0; i < p.length(); i++) {
                pCnt[p.charAt(i) - 'a']++;
                sCnt[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(sCnt, pCnt)) {
                ans.add(0);
            }

            for (int i = 0; i < s.length() - p.length(); i++) {
                --sCnt[s.charAt(i) - 'a'];
                ++sCnt[s.charAt(i + p.length()) - 'a'];
                if (Arrays.equals(sCnt, pCnt)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }

        public List<Integer> findAnagrams2(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) return ans;

            int[] cnt = new int[26];
            for (int i = 0; i < p.length(); i++) {
                cnt[p.charAt(i) - 'a']++;
            }
            for (int r = 0, l = 0; r < s.length(); r++) {
                int cur = s.charAt(r) - 'a';
                cnt[cur]--;
                while (cnt[cur] < 0) {
                    cnt[s.charAt(l++) - 'a']++;
                }
                if (r - l + 1 == p.length()) ans.add(l);
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}
