import java.util.Arrays;

public class FinalPrices_1475 {
    static class Solution {
        public int[] finalPrices(int[] prices) {
            for (int i = 0; i < prices.length - 1; i++) {
                int price = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= price) {
                        prices[i] = price - prices[j];
                        break;
                    }
                }
            }
            return prices;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{10,1,1,6})));

    }
}
