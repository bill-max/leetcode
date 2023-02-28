import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent_347 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            Queue<int[]> heap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[1]));
            for (var num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (var entry : map.entrySet()) {
                if (heap.size() < k) {
                    heap.offer(new int[]{entry.getKey(), entry.getValue()});
                } else {
                    int[] peek = heap.peek();
                    if (entry.getValue() > peek[1]) {
                        heap.poll();
                        heap.offer(new int[]{entry.getKey(), entry.getValue()});
                    }
                }
            }

            return heap.stream().map(h -> h[0]).mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
