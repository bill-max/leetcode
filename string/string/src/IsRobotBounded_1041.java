import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsRobotBounded_1041 {
    static class Solution {
        private final int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public boolean isRobotBounded(String instructions) {
            int idx = 0;
            int[] pos = new int[]{0, 0};
            for (char ch : instructions.toCharArray()) {
                switch (ch) {
                    case 'G' -> advance(pos, idx);
                    case 'L' -> idx = (idx + 1) % 4;
                    case 'R' -> idx = (idx + 3) % 4;
                }
            }
            return idx != 0 || (pos[0] == 0 && pos[1] == 0);
        }

        private void advance(int[] pos, int idx) {
            pos[0] += direction[idx][0];
            pos[1] += direction[idx][1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
    }
}
