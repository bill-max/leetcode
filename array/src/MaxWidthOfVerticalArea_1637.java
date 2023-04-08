import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxWidthOfVerticalArea_1637 {
    static class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            List<Integer> list = new ArrayList<>();
            for (var point : points) {
                list.add(point[0]);
            }
            Collections.sort(list);
            int ans = 0;
            for (int i = 1; i < list.size(); i++) {
                ans = Math.max(list.get(i) - list.get(i - 1), ans);
            }
            return ans;
        }
    }
}
