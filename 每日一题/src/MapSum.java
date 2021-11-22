import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day48 677-键值隐射
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 * @author 李建彤
 */
public class MapSum {
    private Map<String, Integer> map;
    private List<String> keys = new ArrayList<>();
    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (!map.containsKey(key)) {
            map.put(key, val);
            keys.add(key);
        } else {
            map.put(key, val);
        }
    }

    public int sum(String prefix) {
        int ans=0;
        for (String str : keys) {
            if (str.startsWith(prefix)) {
                ans += map.get(str);
            }
        }
        return ans;
    }
}
