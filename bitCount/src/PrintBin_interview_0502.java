import java.math.BigDecimal;

public class PrintBin_interview_0502 {
    static class Solution {
        /**
         * 0.625  625/1000
         */
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            while (num != 0 && sb.length() <= 32) {
                num *= 2;
                if (num >= 1) {
                    num -= 1;
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            return num == 0 ? sb.toString() : "ERROR";
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().printBin(0.078125));
        BigDecimal bigDecimal = new BigDecimal("");
        BigDecimal bigDecimal1 = new BigDecimal(0.0000000d);
        System.out.println(bigDecimal);
    }

}
