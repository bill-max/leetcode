import java.util.HashMap;
import java.util.Map;

public class BuildTree_preAndInorder {
    private int pre_idx;
    private int[] preorder;
    private int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        //前序遍历第一个为根
        pre_idx=0;
        //用hashmap存储
        int index=0;
        for (Integer a : inorder) {
            idx_map.put(a, index++);
        }
        return helper(0, inorder.length-1);

    }
    public TreeNode helper(int in_left, int in_right) {
        //左指针大于右指针时结束
        if (in_left > in_right) {
            return null;
        }
        //找到inorder对应的位置
        int index = idx_map.get(preorder[pre_idx]);
        //该位置为根
        TreeNode root = new TreeNode(preorder[pre_idx]);
        //pre指针位置前进
        pre_idx++;
        //找左子树和右子树
        root.left = helper(in_left, index - 1);
        root.right = helper(index + 1,  in_right);
        return root;
    }
}
