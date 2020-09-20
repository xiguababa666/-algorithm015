import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author xyx
 * @date 2020/9/19 19:13
 */
public class JumpGameII {


    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[] {10,9,8,7,6,5,4,3,2,1,1,0}));
    }


    public int jump(int[] nums) {
        int step = 0;
        int start = 0, end = 1;
        while (end < nums.length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            start = end;
            end = max + 1;
            step++;
        }
        return step;
    }






}
