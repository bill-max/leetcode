import java.util.*;

public class offer_37 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "[]";
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node != null) {
                    res.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else res.append("null,");
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] strings = data.substring(1,data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int cur=1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!strings[cur].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(strings[cur]));
                    queue.add(node.left);
                }
                cur++;
                if (!strings[cur].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(strings[cur]));
                    queue.add(node.right);
                }
                cur++;
            }
            return root;
        }
    }
}
