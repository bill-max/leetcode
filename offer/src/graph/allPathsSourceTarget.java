package graph;

import java.util.ArrayList;
import java.util.List;

public class allPathsSourceTarget {
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            int n = graph.length;
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(graph, 0, path);
            return res;
        }

        private void dfs(int[][] graph, int i, List<Integer> path) {
            if (i == graph.length - 1) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = 0; j < graph[i].length; j++) {
                path.add(graph[i][j]);
                dfs(graph, graph[i][j], path);
                path.remove(path.size() - 1);
            }
        }
    }
}
