import java.util.*;

public class topKFrequent {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Queue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer num = entry.getKey();
                Integer cnt = entry.getValue();
                if (heap.size() < k) {
                    heap.add(num);
                    continue;
                }
                Integer peek = heap.peek();
                if (map.get(peek) < cnt) {
                    heap.poll();
                    heap.add(num);
                }
            }
            return heap.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }
}
