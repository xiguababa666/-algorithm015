import java.util.LinkedList;

/**
 * 226 翻转二叉树
 *
 * @author xyx
 * @date 2020/9/9 17:08
 */
public class InvertBinaryTree {


    /**
     * 递归
     * */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        TreeNode tmpRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmpRight);
        return root;
    }





    /**
     * 广度优先遍历
     * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.pop();
            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
            if (n.left != null) queue.push(n.left);
            if (n.right != null) queue.push(n.right);
        }

        return root;
    }

}
