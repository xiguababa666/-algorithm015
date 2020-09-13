import java.util.*;

/**
 *
 * 77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * @author xyx
 * @date 2020/9/8 14:12
 */
public class Combinations {


    public static void main(String[] args) {
        System.out.println(new Combinations().combine(6, 3));
    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new LinkedList<>();
        List<Integer> path = new ArrayList<>(k);
        recursion(n, k, 1, list, path);
        return list;

    }

    private void recursion(int n, int k, int start, List<List<Integer>> list, List<Integer> path) {

        // 递归终止条件
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }

        /*
        * 剪枝：
        * k - path.size 是还需要的个数
        * 如果已经不满足需要的个数了，就不要继续循环了
        * 比如：n = 5, k = 3    当start=4, path是空时就可以不用往下继续了（组合3,4,5后就不用再继续了）
        * */
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            // 本次递归的处理
            path.add(i);
            // 递归
            recursion(n, k, i + 1, list, path);
            // 回溯的"回"就体现在此
            path.remove(path.size() - 1);

        }
    }

}
