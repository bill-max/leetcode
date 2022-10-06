import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain_646 {
    /*
    1 3   1 6    3 4   5 7 ==> 3

     */
    static class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs.length == 1) return 1;
            int curr = Integer.MIN_VALUE, res = 0;
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            for (int[] p : pairs) {
                if (curr < p[0]) {
                    curr = p[1];
                    res++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{2, 3}, {3, 4}, {1, 2}}));
    }
}
