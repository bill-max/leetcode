import java.util.ArrayList;
import java.util.List;

public class MaximumEvenSplit_2178 {
    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            if (finalSum%2==1) return new ArrayList<>();
            List<Long> ans = new ArrayList<>();
            for (long i = 2; finalSum >= i; i += 2) {
                ans.add(i);
                finalSum -= i;
            }
            ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
            return ans;
        }
    }
}
