public class DieSimulator_1223 {
    static class Solution {
        static final int MOD = 1000000007;

        /**
         * dp[n][7][16]
         * dp[1][1][1]=1 ==>第1次投，点数为1，连续次数为1的序列数
         * dp[2][1][1]=dp[1][2][1]+dp[1][3][1]+dp[1][4][1]+dp[1][5][1]+dp[1][6][1]=5 :第二次投点数为1，连续次数为1，第一次投的除1外的和
         * dp[2][1][2]=dp[1][1][1]
         */
        public int dieSimulator(int n, int[] rollMax) {
            int[][][] d = new int[n + 1][6][16];
            for (int j = 0; j < 6; j++) {
                d[1][j][1] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 6; j++) {
                    for (int k = 1; k <= rollMax[j]; k++) {
                        for (int p = 0; p < 6; p++) {
                            if (p != j) {
                                d[i][p][1] = (d[i][p][1] + d[i - 1][j][k]) % MOD;
                            } else if (k + 1 <= rollMax[j]) {
                                d[i][p][k + 1] = (d[i][p][k + 1] + d[i - 1][j][k]) % MOD;
                            }
                        }
                    }
                }
            }
            int res = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    res = (res + d[n][j][k]) % MOD;
                }
            }
            return res;
        }
    }

}
