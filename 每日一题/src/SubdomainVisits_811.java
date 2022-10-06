import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits_811 {
    static class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<>();
            for (String domain : cpdomains) {
                String[] s = domain.split(" ");
                Integer count = Integer.parseInt(s[0]);

                String[] strings = s[1].split("\\.");
                String domain1 = s[1];
                map.put(domain1, map.getOrDefault(domain1, 0) + count);
                String domain2 = strings[strings.length - 1];
                map.put(domain2, map.getOrDefault(domain2, 0) + count);
                if (strings.length == 3) {
                    String domain3 = strings[1] + "." + strings[2];
                    map.put(domain3, map.getOrDefault(domain3, 0) + count);
                }
            }
            List<String> ans = new ArrayList<>();
            for (String key:map.keySet()) {
                ans.add(map.get(key) + " " + key);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
