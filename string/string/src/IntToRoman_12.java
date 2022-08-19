import java.util.ArrayList;
import java.util.List;

public class IntToRoman_12 {
    static class Solution {
        public String intToRoman(int num) {
            // 1 5 10 50 100 500 1000
            char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
            // 4 9 40 90 400 900
            String[] roman2 = {"IV", "IX", "XL", "XC", "CD", "CM"};
            StringBuilder sb = new StringBuilder();
            List<Integer> numList = new ArrayList<>();
            while (num != 0) {
                numList.add(num % 10);
                num /= 10;
            }
            for (int i = numList.size() - 1; i >= 0; i--) {
                int n = numList.get(i);
                int pos = i * 2;
                if (i == 3) {
                    for (int j = n; n > 0; n--) {
                        sb.append(roman[pos]);
                    }
                } else {
                    if (n==1){
                        sb.append(roman[pos]);
                    }else if (n==4){
                        sb.append(roman2[pos]);
                    }else if(n==5){
                        sb.append(roman[pos+1]);
                    }else if (n==9){
                        sb.append(roman2[pos + 1]);
                    }else {
                        if (n > 5) {
                            sb.append(roman[pos + 1]);
                            for (int k = n - 5; k > 0; k--) {
                                sb.append(roman[pos]);
                            }
                        }else {
                            for (int k = n ; k > 0; k--) {
                                sb.append(roman[pos]);
                            }
                        }
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(58));
    }
}
