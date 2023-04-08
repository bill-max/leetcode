public class MinimumRecolors_2379 {
    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            int r = 0;
            int count = 0;
            while (r < k && r < blocks.length()) {
                if (blocks.charAt(r)=='W') count++;
                r++;
            }
            if (r == blocks.length()) {
                return count;
            }
            int ans = count;
            int l = 0;
            while (r < blocks.length()) {
                if (blocks.charAt(r)=='W') count++;
                if (blocks.charAt(l)=='W') count--;
                ans = Math.min(ans, count);
                r++;
                l++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRecolors("WBBWWBBWBW",7));
    }
}
