import java.util.*;

public class GetFolderNames_1487 {
    static class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();
            for (var name : names) {
                if (!map.containsKey(name)) {
                    ans.add(name);
                    map.put(name, 1);
                } else {
                    int count = map.get(name);
                    String newName = name + "(" + count + ")";
                    while (map.containsKey(newName)) {
                        count++;
                        newName = String.format(name + "(%s)",count);
                    }
                    map.put(name, count + 1);
                    map.put(newName, 1);
                    ans.add(newName);
                }
            }
            return ans.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"wano","wano","wano","wano"})));
    }
}
