/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author xyx
 * @date 2020/9/27 21:52
 */
public class LeetCode235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 有一个为root，或分别在左右子树
        if ((p.val - root.val) * (q.val - root.val) <= 0) return root;
        // 都在左子树
        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        // 都在右子树
        else return lowestCommonAncestor(root.right, p, q);
    }


    public static void main(String[] args) {
        TreeNode root = new SerializeAndDeserializeBinaryTree().deserialize("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = new LeetCode235().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));

        System.out.println(p);

    }


    //[6,2,8,0,4,7,9,null,null,3,5]
    //                6
    //          2           8
    //       0      4    7     9
    //     n   n  3  5

}
