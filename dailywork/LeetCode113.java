import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author xyx
 * @date 2020/9/26 10:12
 */
public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, sum, path, ret);
        return ret;
    }
    private void dfs(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> ret) {
        path.add(root.val);
        if (root.left != null) dfs(root.left, sum, path, ret);
        if (root.right != null) dfs(root.right, sum, path, ret);
        if (root.left == null && root.right == null) {
            int m = path.stream().reduce(Integer::sum).orElse(0);
            if (m == sum) ret.add(new ArrayList<>(path));
        }
        path.removeLast();
    }
}
