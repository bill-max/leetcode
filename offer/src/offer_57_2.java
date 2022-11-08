import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer_57_2 {
    static class Solution {
        public int[][] findContinuousSequence(int target) {
            int i = 1, j = 2, s = 3;
            List<int[]> res = new ArrayList<>();
            while(i < j) {
                if(s == target) {
                    int[] ans = new int[j - i + 1];
                    for(int k = i; k <= j; k++)
                        ans[k - i] = k;
                    res.add(ans);
                }
                if(s >= target) {
                    s -= i;
                    i++;
                } else {
                    j++;
                    s += j;
                }
            }
            return res.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(15)));
    }
}
