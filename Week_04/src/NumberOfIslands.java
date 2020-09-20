/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author xyx
 * @date 2020/9/16 19:03
 */
public class NumberOfIslands {


    public static void main(String[] args) {
        //new NumberOfIslands().numIslands(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}});
        new NumberOfIslands().numIslands(new char[][] {{'1','1','1'},{'0','1','0'},{'1','1','1'}});
    }


    public int numIslands(char[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        int num = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int a = grid[i][j];
                if (a == '1') {
                    num++;
                    fill(grid, i, j, h, w);
                }
            }
        }
        return num;
    }
    private void fill(char[][] grid, int i, int j, int h, int w) {
        if (j <= w - 2 && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            fill(grid, i, j + 1, h, w);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '0';
            fill(grid, i, j - 1, h, w);
        }
        if (i <= h - 2 && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '0';
            fill(grid, i + 1, j, h, w);
        }
        if (i > 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            fill(grid, i - 1, j, h, w);
        }

    }


}
