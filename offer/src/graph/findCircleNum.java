package graph;

public class findCircleNum {
    static class Solution {
        int n;
        boolean[] vis;

        public int findCircleNum(int[][] isConnected) {
            n = isConnected.length;
            vis = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (vis[i]) continue;
                ans++;
                dfs(isConnected, i);
            }
            return ans;
        }

        private void dfs(int[][] isConnected, int cur) {
            vis[cur] = true;
            for (int i = 0; i < isConnected[cur].length; i++) {
                if (isConnected[cur][i] == 1 && !vis[i]) {
                    dfs(isConnected, i);
                }
            }
        }
    }

    static class Solution_set {
        //并查集
        public int findCircleNum(int[][] isConnected) {
            //使用并查集
            //初始化
            int[] parent = new int[isConnected.length];
            for (int i = 0; i < isConnected.length; i++) {
                parent[i] = i;
            }
            //遍历矩阵，合并
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = i + 1; j < isConnected.length; j++) {
                    if (isConnected[i][j] == 1) union(parent, i, j);
                }
            }
            //查询树的数量
            int provinces = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (parent[i] == i) {
                    provinces++;
                }
            }
            return provinces;
        }

        //合并，将i的根节点指定为j，即将i这棵子树挂在j上
        private void union(int[] parent, int i, int j) {
            parent[find(parent, i)] = find(parent, j);
        }

        //递归查询，只有根节点满足 parent[i]=i
        // 每次回归都返回当前节点的父节点(已经被赋值为根节点了，所以每次都返回根节点)
        private int find(int[] parent, int i) {
            if (parent[i] == i) return i;
            else return parent[i] = find(parent, parent[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
