public class Main {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(5, t2, t1);
        TreeNode t6 = new TreeNode(6, t4, t3);
        TreeNode t7 = new TreeNode(7, t6, t5);

        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        System.out.println(new Codec_Preorder().serialize(t7));


    }
}
