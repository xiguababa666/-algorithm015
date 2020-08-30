package homework;

/**
 *
 * 1.删除排序数组中的重复项
 * */

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates1(int[] nums) {


        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;


//        if (nums == null) {
//            return 0;
//        } else if (nums.length < 2) {
//            return nums.length;
//        }
//        int needCoverIdx = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[needCoverIdx] != nums[i])
//                nums[++needCoverIdx] = nums[i];
//        }
//        return needCoverIdx + 1;




//        if (nums == null) {
//            return 0;
//        } else if (nums.length < 2) {
//            return nums.length;
//        }
//        int needCoverIdx = 0;
//        int lastIndex = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (needCoverIdx > 0 && nums[needCoverIdx - 1] >= nums[needCoverIdx]) {
//                if (nums[i] != nums[lastIndex]) {
//                    lastIndex = needCoverIdx;
//                    nums[needCoverIdx++] = nums[i];
//                }
//            } else {
//                if (nums[++needCoverIdx] != nums[needCoverIdx - 1]) {
//                    lastIndex = needCoverIdx;
//                }
//
//            }
//        }
//        return lastIndex + 1;


    }


    public static void main(String[] args) {

        int[] arr = new int[] {1,2,3,4,6,6,6,6,7};
        int i = removeDuplicates1(arr);

        for (int b : arr) {
            System.out.print(b + ",");
        }
        System.out.println();
        System.out.println(i);


    }
}
