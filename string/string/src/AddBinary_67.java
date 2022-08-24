public class AddBinary_67 {
    static class Solution {
        public String addBinary(String a, String b) {
            if (b.length() > a.length()) return addBinary(b, a);
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1;
            while (i >= 0 && j >= 0) {
                int ch1 = a.charAt(i) - '0';
                int ch2 = b.charAt(j) - '0';
                int num = ch1 + ch2;
                if (flag) num++;
                if (num > 1) {
                    num -= 2;
                    flag = true;
                } else
                    flag = false;
                sb.append(num);
                i--;
                j--;
            }
            while (i >= 0) {
                int num = a.charAt(i) - '0';
                if (flag) num++;
                if (num > 1) {
                    num -= 2;
                    flag = true;
                } else
                    flag = false;
                sb.append(num);
                i--;
            }
            if (flag) sb.append('1');
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("111", "111"));
    }
}
