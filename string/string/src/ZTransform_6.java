import java.util.Arrays;

public class ZTransform_6 {
    static class Solution {
        /*
         PAYP  AL ISHI RI NG 4
         p     i     n
         a   l s   i g
         y a   h r
         p     i

         0==> 0+n+2
         1==>
         */
        public String convert(String s, int numRows) {
            if (s.length() <= numRows || numRows == 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                int j = i;
                if (j % (2 * numRows - 2 - 1) == 0 || j % (2 * numRows - 2 - 1) == numRows - 1) {
                    while (j < s.length()) {
                        sb.append(s.charAt(j));
                        j += (2 * numRows - 2);
                    }
                } else {
                    while (j < s.length()) {
                        sb.append(s.charAt(j));
                        if (j + (2 * numRows - 2) - 2 * i < s.length())
                            sb.append(s.charAt(j + (2 * numRows - 2) - 2 * i));
                        j += (2 * numRows - 2);
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        String ans = new Solution().convert("PAYPALISHIRING", 4);
//        System.out.println(ans);
//        System.out.println(ans.equals("PINALSIGYAHRPI"));
        String ad = String.join("-","ff");
        System.out.println(ad);
    }
}
