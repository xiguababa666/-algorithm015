import java.util.*;

/**
 * 47. 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author xyx
 * @date 2020/9/13 15:28
 */
public class Permutationsii {


    public static void main(String[] args) {
        System.out.println(new Permutationsii().permuteUnique(
                new int[] {1,1,2}));
    }

    /**
     * 版本1   全排列后用set去重，有点丑，可以剪枝，但不知道怎么剪
     * */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        permuteUnique1(nums, res, new LinkedList<>(), new boolean[nums.length]);
        return new LinkedList<>(res);
    }
    public void permuteUnique1(int[] nums, Set<List<Integer>> res, LinkedList<Integer> selected, boolean[] used) {

        // 递归终止条件
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            selected.add(nums[i]);
            used[i] = true;
            permuteUnique1(nums, res, selected, used);
            used[i] = false;
            selected.removeLast();
        }
    }





    /**
     * 版本2 看题解，剪枝
     * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        permuteUnique(nums, res, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }
    public void permuteUnique(int[] nums, List<List<Integer>> res, LinkedList<Integer> selected, boolean[] used) {

        // 递归终止条件
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                // 剪枝
                continue;
            }
            selected.add(nums[i]);
            used[i] = true;
            permuteUnique(nums, res, selected, used);
            used[i] = false;
            selected.removeLast();
        }
    }


}
