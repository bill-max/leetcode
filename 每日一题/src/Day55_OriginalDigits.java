import java.util.HashMap;
import java.util.Map;

public class Day55_OriginalDigits {
    public String originalDigits(String s) {
        /**
         * 0-- z
         * 1-- o==o-0-2-4
         * 2-- w
         * 3-- r==r-0-4
         * 4-- u
         * 5-- f==f-4
         * 6-- x
         * 7-- v==v-5
         * 8-- g
         * 9-- n==(n-7-1)/2
         */
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        int[] count_nums = new int[10];
        //0的个数可以通过z唯一标识
        count_nums[0] = count.getOrDefault('z', 0);
        //2的个数可以通过w唯一标识
        count_nums[2] = count.getOrDefault('w', 0);
        //4的个数可以通过u唯一标识
        count_nums[4] = count.getOrDefault('u', 0);
        //6的个数可以通过x唯一标识
        count_nums[6] = count.getOrDefault('x', 0);
        //8的个数可以通过g唯一标识
        count_nums[8] = count.getOrDefault('g', 0);
        count_nums[1] = count.getOrDefault('o', 0) - count_nums[0] - count_nums[2] - count_nums[4];
        count_nums[3] = count.getOrDefault('r', 0) - count_nums[0] - count_nums[4];
        count_nums[5] = count.getOrDefault('f', 0) - count_nums[4];
        count_nums[7] = count.getOrDefault('v', 0) - count_nums[5];
        count_nums[9] = (count.getOrDefault('n', 0) - count_nums[7] - count_nums[1]) / 2;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count_nums[i]; ++j) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
