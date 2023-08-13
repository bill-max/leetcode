package graph;

import java.util.*;

public class isBipartite {
    static class Solution {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;
        private int[] color;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new int[n];
            Arrays.fill(color, UNCOLORED);
            for (int i = 0; i < n; i++) {
                if (color[i] != UNCOLORED)
                    continue;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                color[i] = RED;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    int colorI = color[node] == RED ? GREEN : RED;
                    for (int g : graph[node]) {
                        if (color[g] == UNCOLORED) {
                            q.offer(g);
                            color[g] = colorI;
                        } else if (color[g] != colorI)
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
