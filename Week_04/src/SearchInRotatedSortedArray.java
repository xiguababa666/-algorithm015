/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author xyx
 * @date 2020/9/19 09:29
 */
public class SearchInRotatedSortedArray {


    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(
                //new int[]{9,10,11,1,2,3,4,5,6,7,8}, 11));
                //new int[]{4,5,6,7,8,9,10,11,1,2,3}, 11));
                //new int[]{4,5,6,7,0,1,2}, 0));
                //new int[]{9,10,11,1,2,3,4,5,6,7,8}, 7));
                //new int[]{4,5,6,7,8,9,10,11,1,2,3}, 6));
                new int[]{1}, 1));
    }


    /**
     * 虽然代码行数多点，但这样看着更清晰
     * */
    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            if (nums[l] < nums[mid] ) {
                // 如果左边有序，看target是不是在左边，不在左边就在右边
                if (nums[l] < target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 如果右边有序，看target是不是在右边，不在右就在左
                if (nums[mid] < target && target < nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }

}
