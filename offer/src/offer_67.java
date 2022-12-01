public class offer_67 {
    static class Solution {
        public int strToInt(String str) {
            char[] c = str.trim().toCharArray();
            if (c.length==0) return 0;
            int sign = 1;
            int band = Integer.MAX_VALUE / 10;
            int i = 1;
            int res = 0;
            if (c[0] == '-') sign = -1;
            else if (c[0]!='+') i= 0;
            for (int j = i; j < c.length; j++) {
                if (c[j]>'9'||c[j]<'0') break;
                if (res>band||res==band&&c[j]>'7') return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                res = (c[j] - '0') + res * 10;
            }
            return res * sign;
        }
    }
}
