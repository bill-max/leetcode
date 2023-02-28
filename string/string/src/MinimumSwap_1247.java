public class MinimumSwap_1247 {
    static class Solution {
        public int minimumSwap(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return -1;
            }
            int[] xy = new int[2];
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) continue;
                if (s1.charAt(i) == 'x') {
                    xy[0]++;
                } else {
                    xy[1]++;
                }
            }
            int x = Math.max(xy[0], xy[1]);
            int y = Math.min(xy[0], xy[1]);
            if (x == y) {
                if (x % 2 == 0) return x;
                else return x + 1;
            } else {
                if ((x-y)%2!=0) return -1;
                else if (y%2==0) return (x - y) / 2 + y;
                else return (x - y) / 2 + y + 1;
            }
        }
    }
}
