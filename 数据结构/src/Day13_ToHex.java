import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 405. 数字转换为十六进制数
 * @author 李建彤
 */
public class Day13_ToHex {
    public static void main(String[] args) {
        System.out.println(toHex(15));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

/*        //常规算法
        long numL=num;
        StringBuilder sb=new StringBuilder();
        //负数要处理补码问题，需要加上偏移量
        if (num < 0) {
            numL = (long) (Math.pow(2, 32) + num);
        }
        while (numL != 0) {
            long u=numL%16;
            if (u > 9) {
                sb.append((char) (u - 10 + 'a'));
            }else {
                sb.append(u);
            }
            numL /= 16;
        }
        return sb.reverse().toString();*/

        //位运算
        //将十进制数转化为二进制数，按四位一组，每组与15（1111）求与运算，可以得到当前组位置上十六进制的值
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int n =((num >> (4 * i)) & 15);
            //从第一个不是0的数开始添加
            if (n > 0 || sb.length() > 0) {
                if (n>9){
                    sb.append((char) (n - 10 + 'a'));
                }else {
                    sb.append(n);
                }
            }
        }
        return sb.toString();

    }
}
