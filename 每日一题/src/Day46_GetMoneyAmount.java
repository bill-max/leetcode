public class Day46_GetMoneyAmount {
    //375:猜数字大小Ⅱ
    public int getMoneyAmount(int n) {
        if(n==1) return 0;
        //定义dp矩阵
        int[][] dp = new int[n + 1][n + 1];
        /**
         * dp[i][i]:此时只剩下i为可能的取值，显然需要支付金额为0
         * dp[1][2]:代表此时的可能选取的值有1、2，此时值为猜1的情况 为 1
         * dp[2][3]:代表此时值只有2、3,值为2
         * dp[1][3]:此时值有1、2、3,
         *          值为min(max(0,1+dp[2][3]);max(0,2+dp[1][1],2+dp[3][3]);max(0,3+dp[1][2]))
         *          ==>2
         * ===>一般的
         *
         * i i+1 i+2 ... ... j-2 j-1 j
         * 以i+1为分割点对应的：
         *                 dp1=max(dp[i][i],dp[i+2][j])+i+1
         * 以j-1为分割点对应的:
         *                 dp2=max(dp[i][j-2],dp[j][j])+j-1
         * 特别地,以i为分割点：
         *                 dp0=i+dp[i+1][j];
         * 以j为分割点:
         *                 dp3=j+dp[i][j-1]
         * ==>
         * dp[i][j]=min(dp0,dp1,dp2,dp3)
         *
         * (图示矩阵从1开始)
         * |0 1 2 x x|
         * |  0 2 x x|
         * |    0 3 x|
         * |      0 4|
         * |        0|
         */
        //初始化：对角线上为0，其余为正无穷
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //计算dp矩阵
        //从第二列开始
        for (int j = 2; j < n + 1; j++) {
            //从下往上一次计算每一行的dp
            for (int i = j-1; i >= 1; i--) {
                //除去两端，穷举
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(k + Math.max(dp[i][k - 1], dp[k + 1][j]), dp[i][j]);
                }
                //求两端
                dp[i][j] = Math.min(dp[i][j], i + dp[i + 1][j]);
                dp[i][j] = Math.min(dp[i][j], j + dp[i][j - 1]);
            }
        }
        return dp[1][n];
    }
}
