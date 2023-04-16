public class rowAndMaximumOnes {
    static class Solution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int idx = 0, cnt = 0;
            for (int i = 0; i < mat.length; i++) {
                int sum = 0;
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j]==1) sum++;
                }
                if (sum > cnt) {
                    idx = i;
                    cnt = sum;
                }
            }
            return new int[]{idx, cnt};
        }
    }
}
