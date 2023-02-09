//import java.util.Scanner;//相当于输入输出头文件

import java.util.*;//啥都有头文件
//import java.math.BigInteger;//大数类
import java.math.BigDecimal;//大浮点数
import java.math.*;//关于数学的头文件

public class Template {
    public static void main(String[] args) {
        BigInteger[] sum = new BigInteger[105];//开一个数组
        Scanner cin = new Scanner(System.in);//必须要写这句话（输入）
        int t = cin.nextInt();//输入整数T nextInt() 下一个int型数据
//        while(cin.hasNext()) {//循环输入，hasNext()
//             int n = cin.nextInt();
//        }
        while (t-- != 0) {//java里不能直接写while(t--)，必须是只有真假的表达式
            BigInteger a = cin.nextBigInteger();//输入下一个大数
            BigInteger b = cin.nextBigInteger();//输入下一个大数
            BigInteger c;
            c = a.add(b);//c=a+b
            c = a.subtract(b);//c=a-b
            c = a.multiply(b);//c=a*b
            c = a.divide(b);//c=a/b(整数除法)
            c = a.remainder(b);//c=a%b
            c = a.mod(b);//c=a%b(结果为正数)
            c = BigInteger.ZERO;//c=0
            c = BigInteger.ONE;//c=1
            c = BigInteger.TEN;//c=10 java大数中只有0,1,10
            c = BigInteger.valueOf(7);//c=7
            int n = 7;
            c = BigInteger.valueOf(n);//c=n
            c = a.pow(n);//幂运算 c=pow(a,n)
            c = a.gcd(b);//最大公约数 c=gcd(a,b)
            c = a.abs();//
            c = a.max(b);//c=max(a,b)
            c = a.min(b);//c=min(a,b)
            n = a.compareTo(b);//a<b n=-1;a=b n=0;a>b n=1
            a.equals(b);//a==b
            a.isProbablePrime(2);//判断素数，有一定几率错误，最好手写
            System.out.println(c);//输出c并换行
            System.out.print(c);//输出c
            System.out.println(a + " " + b);//输出a空格b
            BigDecimal d = cin.nextBigDecimal();//输入下一个高精度浮点数
            BigDecimal e = cin.nextBigDecimal();//输入下一个高精度浮点数
            BigDecimal f = d.add(e);//f=d+e
            //...其他和大数类似
            f = d.setScale(2);//保留2位小数，默认四舍五入
            f = d.setScale(2, BigDecimal.ROUND_DOWN);//保留2位小数，向下取整
            f = d.setScale(2, BigDecimal.ROUND_UP);//保留2位小数，向上取整
            f = d.setScale(2, BigDecimal.ROUND_HALF_DOWN);//保留2位小数，四舍五入，正好.5舍去
            f = d.setScale(2, BigDecimal.ROUND_HALF_UP);//保留2位小数，四舍五入，正好.5进位
        }
    }
}