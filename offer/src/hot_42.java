import java.util.ArrayDeque;
import java.util.Deque;

public class hot_42 {
    static class Solution {
        /**
         * 单调栈解法
         * 维护一个递减的单调栈
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = height.length;
            if (n <= 2) return 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }

        /**
         * 双指针解法
         *可算看懂了，原来双指针同时开两个柱子接水
         * 对于每一个柱子接的水，那么它能接的水=min(左右两边最高柱子）-当前柱子高度，这个公式没有问题。同样的，两根柱子要一起求接水，同样要知道它们左右两边最大值的较小值。
         * 问题就在这，假设两柱子分别为 i，j。
         * 那么就有 iLeftMax,iRightMax,jLeftMx,jRightMax 这个变量。
         * 由于 j>i ，故 jLeftMax>=iLeftMax，iRightMax>=jRightMax.
         * 那么，如果 iLeftMax>jRightMax，则必有 jLeftMax >= jRightMax，所有我们能接 j 点的水。
         * 如果 jRightMax>iLeftMax，则必有 iRightMax >= iLeftMax，所以我们能接 i 点的水。
         * 而上面我们实际上只用到了 iLeftMax，jRightMax 两个变量，故我们维护这两个即可。
         * @param height
         * @return
         */
        public int trap2(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }
}
