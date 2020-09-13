import java.util.ArrayList;
import java.util.List;

/**
 * 校验二叉搜索树
 *
 * @author xyx
 * @date 2020/9/9 15:54
 */
public class ValidateBinarySearchTree {

    /**
     * 中序遍历后，对遍历结果做判断，看是不是单调递增
     * */
    public boolean isValidBST1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorderTranversal(root, l);
        if (l.size() <= 1) return true;
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) <= l.get(i - 1)) return false;
        }
        return true;
    }

    private void inorderTranversal(TreeNode n, List<Integer> list) {
        // 中止条件
        if (n == null) return;
        inorderTranversal(n.left, list);
        list.add(n.val);
        inorderTranversal(n.right, list);
    }



    /**
     * 中序遍历，一边遍历一边判断
     * */
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST2(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        if (!isValidBST2(root.right)) return false;
        return true;
    }





    /**
     * 国际站大神的代码
     *
     * */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


}




