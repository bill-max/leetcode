import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class miceAndCheese {
    static class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int n = reward1.length;
            List<int[]> reward = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                reward.add(new int[]{reward1[i], reward2[i]});
            }
            reward.sort((o1, o2) -> o2[0] - o2[1] - (o1[0] - o1[1]));

            int ans = 0;
            for (int[] score : reward) {
                if (k > 0) {
                    ans += score[0];
                    k--;
                } else {
                    ans += score[1];
                }
            }
            return ans;
        }
    }
}
