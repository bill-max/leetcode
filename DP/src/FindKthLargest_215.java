import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest_215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> heap = new PriorityQueue<Integer>(k);
            for (var num : nums) {
                if (heap.size() < k) {
                    heap.offer(num);
                } else {
                    if (num > heap.peek()) {
                        heap.poll();
                        heap.offer(num);
                    }
                }
            }
            return heap.peek();
        }
    }
}
