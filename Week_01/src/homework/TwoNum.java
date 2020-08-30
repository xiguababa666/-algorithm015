package homework;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

  

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 *
 * */

public class TwoNum {


    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        /*
        *
        * map key -> target-nums[i], value -> i
        * 如果数组中的某个元素x能存在于map的key中，则说明 x + nums[map.get(x)] = target
        *
        * */
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer v = target - nums[i];
            if (!map.containsKey(nums[i])) {
                map.put(v, i);
                continue;
            }
            return new int[] {map.get(nums[i]), i};
        }
        return new int[0];
    }


    public static void main(String[] args) {


        int[] arr = twoSum(new int[] {1,2,3,4,8,10,28}, 18);
        System.out.println(arr);

    }



}
