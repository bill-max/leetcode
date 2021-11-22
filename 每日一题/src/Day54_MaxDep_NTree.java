public class Day54_MaxDep_NTree {
    /**
     * DFS
     * @param root 根结点
     * @return  当前结点最大深度
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }
}
