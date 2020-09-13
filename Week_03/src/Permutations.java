import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author xyx
 * @date 2020/9/12 17:26
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations()
                .permute(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }

    /**
     * 回溯  版本1    输入[1,2,3,4,5,6,7,8,9]超时了
     * */
    public List<List<Integer>> permute(int[] nums) {
        //List<List<Integer>> list = new LinkedList<>();
        //List<Integer> selected = new LinkedList<>();
        //permute(nums, list, selected);
        //return list;


        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> selected = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, list, selected, used);
        return list;
    }

    /**
     * 回溯  版本1    输入[1,2,3,4,5,6,7,8,9]超时了
     * */
    //private void permute(int[] nums, List<List<Integer>> ret, List<Integer> selected) {
    //    if (selected.size() == nums.length) {
    //        ret.add(new ArrayList<>(selected));
    //        return;
    //    }
    //    for (int i = 0; i < nums.length; i++) {
    //        if (selected.contains(nums[i])) {
    //            // 此处可能会很耗时
    //            continue;
    //        }
    //        selected.add(nums[i]);
    //        permute(nums, ret, selected);
    //        selected.remove(Integer.valueOf(nums[i]));
    //    }
    //}

    private void permute(int[] nums, List<List<Integer>> ret, LinkedList<Integer> selected, boolean[] used) {
        if (selected.size() == nums.length) {
            ret.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            selected.add(nums[i]);
            used[i] = true;
            permute(nums, ret, selected, used);
            selected.removeLast();
            used[i] = false;
        }
    }

}
