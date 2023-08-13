package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class findOrder {
    /**
     * 拓扑排序问题
     */
    static class Solution1 {
        //dfs
        List<List<Integer>> edges;
        int[] vis;
        int[] res;

        //栈下标
        int index;

        //判断有向图中是否有环
        boolean valid = true;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //建图
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            vis = new int[numCourses];
            res = new int[numCourses];
            index = numCourses - 1;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            //dfs
            for (int i = 0; i < numCourses && valid; i++) {
                if (vis[i] == 0) {
                    dfs(i);
                }
            }
            //如果有环，则无结果
            if (!valid) return new int[0];
            return res;
        }

        private void dfs(int i) {
            //将节点标记为搜索中
            vis[i] = 1;
            //搜索相邻节点
            //有环就停止
            for (int v : edges.get(i)) {
                if (vis[v] == 0) {
                    dfs(v);
                    if (!valid) return;
                } else if (vis[v] == 1) {
                    valid = false;
                    return;
                }
            }
            //将结点标记为已完成
            vis[i] = 2;
            res[index--] = i;
        }
    }

    static class Solution2 {
        //bfs
        List<List<Integer>> edges;
        int[] indeg;//每个节点的入度
        int[] res;
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            indeg = new int[numCourses];
            res = new int[numCourses];
            index = 0;
            //建图，
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                indeg[info[0]]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            //将所有入度为0的节点放到队列中
            for (int i = 0; i < numCourses; i++) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            //bfs
            while (!queue.isEmpty()) {
                int u = queue.poll();
                res[index++] = u;
                //遍历与该节点相连的节点
                for (int v : edges.get(u)) {
                    //入度减一
                    --indeg[v];
                    //如果入度为0，说明下次可以添加该节点
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            if (index != numCourses) {
                return new int[0];
            }
            return res;
        }
    }
}














