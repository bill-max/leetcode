public class tank {
    static class Solution {
        public int distanceTraveled(int a, int b) {
            int ans = 0;
            while (a >= 5 && b > 0) {
                a -= 5;
                ans += 50;
                b--;
                a++;
            }
            ans += a * 10;
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distanceTraveled(6, 1));
    }
}
