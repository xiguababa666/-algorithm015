/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 221. 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0          1 0 1 0 0
 * 1 0 1 1 1   ->     1 0 3 2 1
 * 1 1 1 1 1          1 1 2 2 1
 * 1 0 1 1 1          1 0 1 1 1
 *
 * 输出: 9
 *
 *
 * @author xyx
 * @date 2020/10/8 20:44
 */
public class LeetCode221 {


    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) return 0;
        int c = matrix[0].length;
        if (c == 0) return 0;
        int[][] dp = new int[h][c];
        int max = 0;
        for (int i = h - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                char ch = matrix[i][j];
                if (i == h - 1 || j == c - 1) {
                    dp[i][j] = ch - '0';
                } else if (ch == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j + 1], dp[i][j + 1]), dp[i + 1][j]) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }


    // todo 优化版


}
