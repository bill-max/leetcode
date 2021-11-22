import java.util.Arrays;

public class Day7_PlusOne {
    public static void main(String[] args) {
        int[] num = {1,1};
        int[] result;
        result=plusOne(num);
        for (int a:
            result) {
            System.out.print("|"+a+"|");
        }
    }
    public static int[] plusOne(int[] digits) {
       /* digits[digits.length-1]++;
        if (digits[digits.length-1]==10) {
            for (int i = digits.length - 1; i > 0; i--) {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    digits[i - 1]++;
                }
            }
        }
        if(digits[0]==10){
                int[] result=new int[digits.length+1];
                result[0]=1;
                return result;
        }
        return digits;*/

        //优化
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
