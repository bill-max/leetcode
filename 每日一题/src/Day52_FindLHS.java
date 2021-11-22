import java.util.HashMap;
import java.util.Map;

public class Day52_FindLHS {
    public int findLHS(int[] nums) {
        int ans=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int countCur = map.get(num);
            int countPre = map.getOrDefault(num - 1, 0);
            int countPost=map.getOrDefault(num+1, 0);
            if (map.containsKey(num - 1) || map.containsKey(num + 1)) {
                ans = Math.max(Math.max(countPre,countPost)+countCur, ans);
            }
        }
        return ans;
    }
}
