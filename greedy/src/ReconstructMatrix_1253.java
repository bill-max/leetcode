import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructMatrix_1253 {
    static class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> ans = new ArrayList<>();
            int sum = upper + lower;
            for (int col : colsum) {
                if (col == 2) {
                    upper--;
                    lower--;
                }
                sum -= col;
            }
            if (upper < 0 || lower < 0 || sum != 0) return ans;
            List<Integer> up = new ArrayList<>();
            List<Integer> low = new ArrayList<>();
            for (int col : colsum) {
                if (col == 2) {
                    up.add(1);
                    low.add(1);
                } else if (col == 0) {
                    up.add(0);
                    low.add(0);
                } else if (upper > 0) {
                    up.add(1);
                    low.add(0);
                    upper--;
                } else if (lower > 0) {
                    up.add(0);
                    low.add(1);
                    lower--;
                } else {
                    return ans;
                }
            }
            ans.add(up);
            ans.add(low);
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }
}
