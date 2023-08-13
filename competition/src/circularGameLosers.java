import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class circularGameLosers {
    class Solution {
        public int[] circularGameLosers(int n, int k) {
            Set<Integer> set = new HashSet<>();
            int num = 1, i = 1;
            while (!set.contains(num)) {
                set.add(num);
                num += i * k;
                num %= n;
                num = num == 0 ? n : num;
                i++;
            }
            List<Integer> result = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (!set.contains(j)) {
                    result.add(j);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();

        }
    }
}
