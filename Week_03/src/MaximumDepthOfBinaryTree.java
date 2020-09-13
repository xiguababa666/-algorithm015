import java.util.*;

/**
 * 104. 二叉树的最大深度
 * 111. 二叉树的最小深度
 *
 * @author xyx
 * @date 2020/9/9 17:40
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 还是递归
     * */
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int dpl = minDepth1(root.left);
        int dpr = minDepth1(root.right);
        if (dpl == 0) {
            return dpr + 1;
        } else if (dpr == 0) {
            return dpl + 1;
        } else {
            return Math.min(dpl, dpr) + 1;
        }
    }
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int dpl = minDepth2(root.left);
        int dpr = minDepth2(root.right);
        return dpl == 0 || dpr == 0 ? dpl + dpr + 1 : Math.min(dpl, dpr) + 1;
    }








    /**
     * 不用递归呢？ todo
     * */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(root));
        int lv = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> ns = queue.poll();
            if (!ns.isEmpty()) lv++;
            List<TreeNode> nextLv = new LinkedList<>();
            for (TreeNode n : ns) {
                if (n.left != null) nextLv.add(n.left);
                if (n.right != null) nextLv.add(n.right);
            }
            if (nextLv.size() > 0) queue.offer(nextLv);
        }
        return lv;
    }






}
