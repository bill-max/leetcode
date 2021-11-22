import java.util.function.IntFunction;

public class Day11_MyAtoi {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s.length()==0){
            return 0;
        }
        if (s.charAt(0)==' '&&s.length()==1){
            return 0;
        }
        long result=0;
        int index=0;
        //flag=0时为正数;flag=1时为负数
        int flag=0;
        int i = 0;
        while (s.charAt(i)==' ') {
            i++;
        }
        if (s.charAt(i)=='-'){
            flag=1;
            i++;
        }else if(s.charAt(i)=='+'){
            flag=0;
            i++;
        }
        char[] chars = new char[s.length()];
        while (i<s.length()&&Character.isDigit(s.charAt(i))) {
            chars[index++] = s.charAt(i);
            i++;
        }
        int j=0;
        while (index>0){
            result += (chars[--index] - '0') * Math.pow(10,j++);
        }
        if (flag == 1) {
            if (-result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else {
                return (int)-result;
            }
        } else {
            if (result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return (int)result;
            }
        }
    }
}
