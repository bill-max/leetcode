package stack;

import java.util.*;
import java.util.Collections;

public class asteroidCollision {
    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int asteroid : asteroids) {
                if (stack.isEmpty() || stack.peek() < 0 || (stack.peek() > 0 && asteroid > 0)) {
                    stack.push(asteroid);
                } else {
                    boolean flag = true;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        if (stack.peek() + asteroid == 0) {
                            stack.pop();
                            flag = false;
                            break;
                        } else if (stack.peek() + asteroid < 0) {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) stack.push(asteroid);
                }
            }
            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{-2, -1, 1, -2})));
    }
}
