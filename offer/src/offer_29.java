import java.util.ArrayList;
import java.util.List;

public class offer_29 {
    static class Solution {
        /**
         * 每次该转向的时候就设置左右边界
         *
         * @param matrix
         * @return
         */
        public int[] spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix.length == 0) {
                return new int[0];
            }
            int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            while (true) {
                for (int col = left; col <= right; ++col) {
                    res.add(matrix[up][col]);
                }
                if (++up > down) {
                    break;
                }
                for (int row = up; row <= down; ++row) {
                    res.add(matrix[row][right]);
                }
                if (--right < left) {
                    break;
                }
                for (int col = right; col >= left; --col) {
                    res.add(matrix[down][col]);
                }
                if (--down < up) {
                    break;
                }
                for (int row = down; row >= up; --row) {
                    res.add(matrix[row][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
