public class MostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int left=0,right=1;
            int maxWater = height[right] - height[left];
            while (right < height.length && left < right) {
                int curWater = height[right] - height[left];
                if (curWater > maxWater) {

                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
