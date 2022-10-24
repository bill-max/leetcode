public class offer_20 {
    static class Solution {
        public boolean isNumber(String str) {
            String s = str.trim();
            if (s.length() == 0) return false;
            if (s.length() == 1) return (s.charAt(0) >= '0' && s.charAt(0) <= '9');
            int cur = 0;
            //找到第一个e 的位置
            while (cur < s.length() && s.charAt(cur) != 'e' && s.charAt(cur) != 'E') {
                cur++;
            }
            boolean flagE = s.contains("e") || s.contains("E");
            //e 不能在第一个或最后一个
            if (flagE && (cur == 0 || cur >= s.length() - 1)) {
                return false;
            }
            if (flagE) {
                return (isInteger(s.substring(0, cur)) || isDecimal(s.substring(0, cur))) && isInteger(s.substring(cur + 1));
            } else {
                return isInteger(s) || isDecimal(s);
            }
        }

        private boolean isDecimal(String s) {
            if (s.length() < 2) return false;
            int cur = 0;
            boolean flagPoint = false;
            while (cur < s.length()) {
                if ((s.charAt(cur) == '-' || s.charAt(cur) == '+') && cur == 0) {
                    cur++;
                } else if (s.charAt(cur) == '.') {
                    //， 只能有一个
                    if (flagPoint) return false;
                    //。 可以在第一个和最后一个
                    if (cur == 0 || (cur == s.length() - 1 && isIn(s.charAt(cur - 1)))) {
                        cur++;
                        //.的前后必须都是数字
                    } else if (isIn(s.charAt(cur - 1)) || (cur != s.length() - 1) && isIn(s.charAt(cur + 1))) {
                        cur++;
                    } else {
                        return false;
                    }
                    flagPoint = true;
                    //如果是数字
                } else if (isIn(s.charAt(cur))) {
                    cur++;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isInteger(String s) {
            if (s.length() < 2) {
                return isIn(s.charAt(0));
            }
            int cur = 0;
            while (cur < s.length()) {
                if ((s.charAt(cur) == '-' || s.charAt(cur) == '+') && cur == 0) {
                    cur++;
                } else if (s.charAt(cur) <= '9' && s.charAt(cur) >= '0') {
                    cur++;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isIn(char ch) {
            return ch <= '9' && ch >= '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("-."));
    }
}
