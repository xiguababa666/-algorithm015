import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * 501. 二叉搜索树中的众数
 *
 * 2020-09-24
 *
 * @author xyx
 * @date 2020/9/24 18:53
 */
public class LeetCode501 {

    private Integer last;
    private int count = 0;
    private int maxCount = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    private void dfs(TreeNode n, List<Integer> list) {
        if (n == null) return;
        dfs(n.left, list);
        if (last == null || last != n.val) count = 1;
        else count++;
        last = n.val;
        if (count == maxCount) {
            list.add(last);
        }
        if (count > maxCount) {
            list.clear();
            list.add(last);
            maxCount = count;
        }
        dfs(n.right, list);
    }

}
