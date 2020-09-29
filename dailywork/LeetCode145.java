import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author xyx
 * @date 2020/9/29 11:39
 */
public class LeetCode145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
    private void dfs(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        dfs(root.left, ret);
        dfs(root.right, ret);
        ret.add(root.val);
    }






    /**
     * 标记法
     * */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<StateFrame> stack1 = new Stack<>();
        stack1.push(new StateFrame(root));
        while (!stack1.isEmpty()) {
            StateFrame n = stack1.pop();
            if (n.flag == 1) {
                ret.add(n.node.val);
            } else {
                n.flag = 1;
                stack1.push(n);
                if (n.node.right != null) stack1.push(new StateFrame(n.node.right));
                if (n.node.left != null) stack1.push(new StateFrame(n.node.left));
            }
        }
        return ret;
    }
    static class StateFrame {
        TreeNode node;
        int flag;
        StateFrame(TreeNode n) {
            this.node = n;
        }
    }







}
