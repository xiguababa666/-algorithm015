/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author xyx
 * @date 2020/9/19 14:08
 */
public class JumpGame {


    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int step = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < step) step++;
            else step = 1;
        }
        return step == 1;
    }


}
