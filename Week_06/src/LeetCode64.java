/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 * dp[j] = grid[i][j] + min(dp[j + 1], dp[j])
 *
 *  @author xyx
 * @date 2020/10/2 21:34
 */
public class LeetCode64 {


    public static void main(String[] args) {
        new LeetCode64().minPathSum(
                new int[][] {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                });
    }


    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        if (w == 0) return 0;
        int[] dp = new int[w];
        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                if (j >= w - 1) dp[j] = grid[i][j] + dp[j];
                else if (i >= h - 1) dp[j] = grid[i][j] + dp[j + 1];
                else dp[j] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
            }
        }
        return dp[0];
    }


}
