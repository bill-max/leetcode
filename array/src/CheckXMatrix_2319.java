import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckXMatrix_2319 {
    static class Solution {
        public boolean checkXMatrix(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == j || (i + j) == grid.length - 1) {
                        if (grid[i][j]==0) return false;
                    }else
                        if (grid[i][j]!=0) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkXMatrix(new int[][]{{1,0,0,2},{0,2,3,5},{0,3,4,0},{2,0,0,3}}));
    }
}
