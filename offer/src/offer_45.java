import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class offer_45 {
    static class Solution {
        /**
         * 核心思想：贪心  重写排序规则
         * 只需要比较 o1+o2>o2+o1 即可
         *
         * @param nums
         * @return
         */
        public String minNumber(int[] nums) {
            return Arrays.stream(nums).boxed().map(item -> Integer.toString(item)).sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.joining());
        }

        public String minNumber2(int[] nums) {
            List<String> collect = Arrays.stream(nums).boxed().map(item -> Integer.toString(item)).collect(Collectors.toList());
            Collections.sort(collect, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            StringBuilder sb = new StringBuilder();
            for (String s : collect) {
                sb.append(s);
            }
            return sb.toString();
        }

        public String minNumber3(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }

    }
}

