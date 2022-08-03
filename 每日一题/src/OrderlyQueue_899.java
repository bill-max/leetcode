import java.awt.image.BandedSampleModel;
import java.util.Arrays;

public class OrderlyQueue_899 {
    static class Solution {
        public String orderlyQueue(String s, int k) {
            String ans = "";
            if (k != 1) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                ans = chars.toString();
            } else {
                String smallest = s;
                StringBuilder sb = new StringBuilder(s);
                int n = s.length();
                for (int i = 1; i < n; i++) {
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(c);
                    if (sb.toString().compareTo(smallest) < 0) {
                        smallest = sb.toString();
                    }
                }
                return smallest;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().orderlyQueue("cba", 1));
    }
}
