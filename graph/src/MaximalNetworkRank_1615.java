import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximalNetworkRank_1615 {
    static class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] count = new int[n];
            Set[] edge = new Set[n];
            for (int i = 0; i < n; i++) {
                edge[i] = new HashSet<Integer>();
            }

            for (var road : roads) {
                edge[road[0]].add(road[1]);
                count[road[0]]++;
                count[road[1]]++;
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int curCount = count[i] + count[j];
                    if (edge[i].contains(j) || edge[j].contains(i)) {
                        curCount--;
                    }
                    ans = Math.max(ans, curCount);
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maximalNetworkRank(4, new int[][]{{1, 0}, {0, 3}, {1, 2}, {1, 3}}));

//        Integer a = 0;
//        System.out.println(a.equals(1));
    }

}
