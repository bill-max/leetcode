package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class dailyTemperatures {
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = temperatures.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int pre = stack.pop();
                    ans[pre] = i - pre;
                }
                stack.push(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{71, 70, 72})));
    }
}
