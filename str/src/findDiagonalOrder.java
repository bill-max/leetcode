import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//斜对角遍历，遇到偶数列翻转再加入结果集
public class findDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];

        int k = 0;
        boolean bXFlag = true;
        //坐标（x, y）相加的和i是递增的
        for (int i = 0; i < m + n; i++){
            int pm = bXFlag ? m : n;
            int pn = bXFlag ? n : m;

            //当初始值超过 x 的上限时，不足的部分加到 y 上面
            int x = (i < pm) ? i : pm - 1;
            int y = i - x;

            while (x >= 0 && y < pn){
                //方向相反时，x，y是相反的
                nums[k++] = bXFlag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }
            //这一趟结束了，循环起来，标志位变化。
            bXFlag = !bXFlag;
        }

        return nums;

    }
}
