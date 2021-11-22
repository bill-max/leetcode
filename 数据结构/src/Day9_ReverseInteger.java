public class Day9_ReverseInteger {
    public static void main(String[] args) {
        int x = -2147483648;
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
