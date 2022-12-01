import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hot_9 {
    static class Solution {
        /**
         * 1 2 1 + 1 2 1 = 2 4 2
         * 1 2 3 + 1 2 3 = 2 4 6
         *
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            int reverse = 0;
            int temp = x;
            while (temp != 0) {
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }
            return x == reverse;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
