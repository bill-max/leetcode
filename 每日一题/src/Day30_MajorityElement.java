import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day30_MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            int count = map.getOrDefault(num, 0)+1;
            if (count > nums.length / 3 && !res.contains(num)) {
                res.add(num);
            }
            map.put(num, count);
        }
        return res;
    }
}
