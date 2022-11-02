import java.util.ArrayList;
import java.util.List;

public class offer_43 {
    static class Solution {
        /**
         * 1 出现的个数
         *  2 3 0 4
         * cur = 0 时，此时 1 的个数只能由高位决定  high*digital == 230
         * cur = 1 时，此时 1 的个数 由高位 high 和低位 low 决定，计算公式为：high×digit+low+1
         * cur >1 时   (high+1)×digit
         * @param n
         * @return
         */
        public int countDigitOne(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while(high != 0 || cur != 0) {
                if(cur == 0) res += high * digit;
                else if(cur == 1) res += high * digit + low + 1;
                else res += (high + 1) * digit;
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(10));
    }
}
