import java.util.Arrays;

public class offer_04 {
    static class Solution {
        /**
         * 二维数组查找，数组从左到右递增，从上到下递增
         * 二分查找
         *
         * @param matrix input matrix
         * @param target target number
         * @return Boolean
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;
            int i = 0;
            while (i < m && matrix[i][n - 1] < target) {
                i++;
            }
            while (i < m) {
                int search = Arrays.binarySearch(matrix[i], target);
                if (search >= 0 && search < n && matrix[i][search] == target) return true;
                i++;
            }
            return false;
        }
    }

    static class Solution2 {
        /**
         * 二维数组查找，数组从左到右递增，从上到下递增
         * 斜对角线查找
         *
         * @param matrix input matrix
         * @param target target number
         * @return Boolean
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return false;
            int i = matrix[0].length - 1, j = 0;
            while (i >= 0 && j < matrix.length) {
                if (matrix[j][i] > target) i--;
                else if (matrix[j][i] < target) j++;
                else return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 17));
    }
}
