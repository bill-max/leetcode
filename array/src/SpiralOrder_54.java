import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
            int i = 0;
            int count = (Math.min(m, n) + 1) / 2;
            // 从外部向内部遍历，逐层打印数据
            while (i < count) {
                for (int j = i; j < n - i; j++) {
                    ans.add(matrix[i][j]);
                }
                for (int j = i + 1; j < m - i; j++) {
                    ans.add(matrix[j][(n - 1) - i]);
                }
                for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                    ans.add(matrix[(m - 1) - i][j]);
                }
                for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                    ans.add(matrix[j][i]);
                }
                i++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
