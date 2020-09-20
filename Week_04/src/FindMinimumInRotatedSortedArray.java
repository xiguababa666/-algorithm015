/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author xyx
 * @date 2020/9/19 11:33
 */
public class FindMinimumInRotatedSortedArray {


    public static void main(String[] args) {
        //System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{2,3,4,5,6,7,8,9,1}));
        //System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{6,7,8,9,1,2,3,4,5}));
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{2,1}));
    }



    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < min) min = nums[mid];
            if (nums[l] < nums[mid]) {
                // 左边有序
                if (nums[l] < min) min = nums[l];
                l = mid ;
            } else {
                // 右边有序
                if (nums[mid+1] < min) min = nums[mid+1];
                r = mid;
            }
        }
        return min > nums[l] ? nums[l] : min;
    }

}
