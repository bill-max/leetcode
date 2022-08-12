import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople_1282 {
    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                int size = groupSizes[i];
   /*             if (!map.containsKey(size)) {
                    map.put(size, new ArrayList<>());
                }*/
                map.putIfAbsent(size, new ArrayList<>());
                map.get(size).add(i);
            }

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (value.size() == key) {
                    ans.add(value);
                } else {
                    int ptr = 0;
                    while (ptr < value.size()) {
                        ans.add(new ArrayList<>(value.subList(ptr, ptr + key)));
                        ptr += key;
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        System.out.println(lists);
    }
}
