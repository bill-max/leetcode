
public class NearestValidPoint_1779 {
    static class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int minDis = Integer.MAX_VALUE;
            int minPos = -1;
            int m = points.length;
            for (int i = 0; i < m; i++) {
                if (x == points[i][0] || y == points[i][1]) {
                    int dis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                    if (dis < minDis) {
                        minDis = dis;
                        minPos = i;
                    }
                }
            }
            return minPos;
        }
    }
}
