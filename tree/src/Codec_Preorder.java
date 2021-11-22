import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec_Preorder {
    /**
     * Encodes a tree to a single string.
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        String str = "";
        str = encHelper(root, str);
        return str;
    }
    //先序遍历(递归)
    public String encHelper(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val+",";
            str = encHelper(root.left, str);
            str = encHelper(root.right, str);
        }
        return str;
    }

    /**
     * Decodes your encoded data to tree.
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] str=data.split(",");
        List<String> res = new LinkedList<>(Arrays.asList(str));
        return decHelper(res);
    }
    public TreeNode decHelper(List<String> list){
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = decHelper(list);
        root.right = decHelper(list);
        return root;
    }

}
