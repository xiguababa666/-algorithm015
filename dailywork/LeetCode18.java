import java.util.*;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author xyx
 * @date 2020/9/26 08:23
 */
public class LeetCode18 {


    public static void main(String[] args) {

        //new TestA().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 1);
        //new TestA().fourSum(new int[]{1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5}, 8);
        new LeetCode18().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            int av = nums[a];
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < nums.length - 2; b++) {
                int bv = nums[b];
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = b + 1;
                int d = nums.length - 1;
                while(c < d) {
                    int ret = av + bv + nums[c] + nums[d];
                    if (ret == target) {
                        list.add(Arrays.asList(av, bv, nums[c], nums[d]));
                        while (++c < d && nums[c] == nums[c - 1]);
                        while (c < --d && nums[d] == nums[d + 1]);
                    } else if (ret > target) {
                        d--;
                    } else {
                        c++;
                    }
                }

            }
        }

        return list;
    }




}
