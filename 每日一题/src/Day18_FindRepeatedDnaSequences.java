import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day18_FindRepeatedDnaSequences {
    static final int L = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap();
        List<String> ans=new ArrayList();
        int n = s.length();
        for (int i = 0; i <=n-L; i++) {
            String sub = s.substring(i, i + L);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;

    }
}
