import java.util.*;

public class MaxSlidingWindow_239 {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[deque.peekFirst()]);
            for (int i = k; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans.add(nums[deque.peekFirst()]);
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
