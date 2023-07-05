package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class calcEquation {
    static class Solution {
        private Map<String, Integer> vars = new HashMap();
        private int idx = 0;
        private double[][] map = new double[41][41];
        private boolean[][] vis;

        private double dfs(int cur, int end, double res) {
            if (cur == end) return res;
            for (int i = 0; i < 41; ++i) {
                if (map[cur][i] > 0 && !vis[cur][i]) {
                    vis[cur][i] = true;
                    double now = dfs(i, end, res * map[cur][i]);
                    if (now > 0) return now;
                }
            }
            return -1.0;
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            //建图
            for (int i = 0; i < equations.size(); ++i) {
                String fir = equations.get(i).get(0), sec = equations.get(i).get(1);
                if (!vars.containsKey(fir)) vars.put(fir, idx++);
                if (!vars.containsKey(sec)) vars.put(sec, idx++);
                map[vars.get(fir)][vars.get(sec)] = values[i];
                map[vars.get(sec)][vars.get(fir)] = 1.0 / values[i];
            }

            double[] ans = new double[queries.size()];
            for (int i = 0; i < queries.size(); ++i) {
                String fir = queries.get(i).get(0), sec = queries.get(i).get(1);
                //未找到
                if (!vars.containsKey(fir) || !vars.containsKey(sec)) {
                    ans[i] = -1.0;
                    continue;
                }
                //重置vis数组
                vis = new boolean[41][41];
                ans[i] = dfs(vars.get(fir), vars.get(sec), 1.0);
            }
            return ans;
        }
    }
}
