package homework;

/**
 *
 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

  

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
  

 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 *
 * */

public class MergeSortedArray {



    // 从后往前遍历
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ml = m - 1, nl = n - 1;
        int lastFill = m + n - 1;
        while (lastFill >= 0) {
            if (nl < 0 || (ml >= 0 && nums1[ml] > nums2[nl])) {
                nums1[lastFill] = nums1[ml--];
            } else {
                nums1[lastFill] = nums2[nl--];
            }
            lastFill--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};

        merge(nums1, 0, nums2, 1);


        for (int a : nums1) {
            System.out.print(a + ",");
        }

    }

}
