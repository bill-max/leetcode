import java.util.*;

public class LowestCommonAncestor {
    private TreeNode ans;
    public void Solution() {
        this.ans = null;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //在当前节点
        boolean inCurrentNode = root.val == p.val || root.val == q.val;
        //在左节点
        boolean inLeft = dfs(root.left,p,q);
        //在右节点
        boolean inRight = dfs(root.right,p,q);
        if((inLeft && inRight) || (inCurrentNode && (inLeft || inRight))){
            ans = root;
        }
        return inLeft || inRight || inCurrentNode;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

