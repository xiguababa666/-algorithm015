import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author xyx
 * @date 2020/8/31 16:57
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer need = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(need, i);
        }
        return new int[] {};
    }


    public static void main(String[] args) {

        twoSum(new int[] {2,7,10,15}, 9);
    }
}
