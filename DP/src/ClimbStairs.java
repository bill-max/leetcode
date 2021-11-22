public class ClimbStairs {
     /* 确定dp数组（dp table）以及下标的含义
        确定递推公式
        dp数组如何初始化
        确定遍历顺序
        举例推导dp数组*/
    public int climbStairs(int n) {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         * 1-> 1
         * 2-> 1+1;2  ==2
         * 3-> 1+1+1;1+2;2+1 ==3
         * 4-> 2+1+1;1+2+1;1+1+2;2+2;1+1+1+1 ==5
         *
         * f(x)=f(x-1)+f(x-2)
         */
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
