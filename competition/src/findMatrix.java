import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findMatrix {
    static class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int cnt = 0;
            for (int num : nums) {
                cnt = Math.max(cnt, map.getOrDefault(num, 0) + 1);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                ans.add(new ArrayList<>());
            }

            for (Map.Entry entry : map.entrySet()) {
                Integer key = (Integer) entry.getKey();
                Integer value = (Integer) entry.getValue();
                for (int i = 0; i < value; i++) {
                    ans.get(i).add(key);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMatrix(new int[]{1,2,3,4,1,2,3,1}));
    }
}
