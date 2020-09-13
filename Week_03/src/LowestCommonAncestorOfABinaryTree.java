import java.util.Stack;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author xyx
 * @date 2020/9/11 14:13
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 第一版: so ugly
     * */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pParent = new Stack<>();
        Stack<TreeNode> qParent = new Stack<>();
        path(root, p, pParent);
        path(root, q, qParent);
        int cmpCount = Math.min(pParent.size(), qParent.size());
        TreeNode parent = null;
        while (cmpCount > 0) {
            TreeNode pp = pParent.pop();
            TreeNode qp = qParent.pop();
            if (pp == qp) {
                parent = pp;
            } else {
                break;
            }
            cmpCount--;
        }
        return parent;
    }
    private boolean path(TreeNode n, TreeNode t, Stack<TreeNode> l) {
        if (n == t) {
            l.push(n);
            return true;
        }
        if (n == null) return false;
        if (path(n.left, t, l) || path(n.right, t, l)) {
            l.push(n);
            return true;
        }
        return false;
    }


    /**
     * 第二版  看题解
     *
     * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // 中止条件
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    /**
     * 第二版  看题解  更简洁
     * */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // 中止条件
        if (root == null || root == p || root == q) return null;
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }





    //                         3
    //              5                      1
    //        6           2          0            8
    //                 7     4

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode n = s.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        //TreeNode n = s.deserialize("[3]");
        LowestCommonAncestorOfABinaryTree a = new LowestCommonAncestorOfABinaryTree();
        TreeNode p = a.find(n, 3);
        TreeNode q = a.find(n, 3);
        TreeNode com = a.lowestCommonAncestor3(n, p, q);
        System.out.println(com.val);
    }






    private TreeNode find(TreeNode t, int val) {

        if (t == null || val == t.val) {
            return t;
        }
        TreeNode l = find(t.left, val);
        if (l == null) {
            return find(t.right, val);
        } else {
            return l;
        }
    }






}
