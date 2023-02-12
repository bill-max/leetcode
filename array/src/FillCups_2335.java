import java.util.Arrays;
import java.util.Comparator;

public class FillCups_2335 {
    static class Solution {
        /**
         * 每次只选最高的两个减
         */
        public int fillCups(int[] amount) {
            Arrays.sort(amount);
            if (amount[2] > amount[1] + amount[0]) {
                return amount[2];
            }
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
    }
}
