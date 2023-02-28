import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest_215 {
    static class Solution {
        //topK问题
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
            for (int i = 0; i < k; i++) {
                queue.offer(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                Integer peek = queue.peek();
                if (peek < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
            return queue.peek();
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 1, 2, 6, 5, 4}, 2));
    }
}
