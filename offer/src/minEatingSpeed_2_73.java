public class minEatingSpeed_2_73 {
    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int up = 0;
            for (int pile : piles) {
                up = Math.max(up, pile);
            }
            int low = 1;
            while (low < up) {
                int speed = low + (up - low ) / 2;
                long time = getTime(piles, speed);
                if (time <= h) {
                    up = speed;
                } else {
                    low = speed + 1;
                }
            }
            return low;
        }

        private long getTime(int[] piles, int speed) {
            long time = 0;
            for (int pile : piles) {
                time += pile % speed == 0 ? pile / speed : pile / speed + 1;
            }
            return time;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
