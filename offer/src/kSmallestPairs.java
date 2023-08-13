import java.util.*;

public class kSmallestPairs {
    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int m = nums2.length;
            Queue<int[]> heap = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
            for (int i = 0; i < Math.min(n, k); i++) {
                heap.offer(new int[]{i, 0});
            }

            List<List<Integer>> ans = new ArrayList<>();
            while (k-- > 0 && !heap.isEmpty()) {
                int[] idxPair = heap.poll();
                ans.add(Arrays.asList(nums1[idxPair[0]], nums2[idxPair[1]]));
                if (idxPair[1] + 1 < m) {
                    heap.offer(new int[]{idxPair[0], idxPair[1] + 1});
                }
            }

            return ans;
        }
    }
}
