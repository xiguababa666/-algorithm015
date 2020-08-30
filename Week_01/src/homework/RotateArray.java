package homework;

/**
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的 原地 算法。

 *
 * */

public class RotateArray {


    // 暴力1
    public static void rotate1(int[] nums, int k) {


        while (k-- > 0) {
            int last = nums[0];
            for (int i = 1; i < nums.length; i++) {

                int tmp = nums[i];
                nums[i] = last;
                last = tmp;

            }
            nums[0] = last;
        }
    }


    // 暴力2
    public static void rotate2(int[] nums, int k) {

        if (k <= 0) return;
        int len = nums.length;
        int start = 0;
        while (start < len - k) {
            if (len - start > k * 2) {
                for (int i = 0; i < k; i++) {
                    int a = len - i - 1;
                    int b = k - 1 - i + start;
                    int tmp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = tmp;
                }
                start += k;
            } else {
                break;
            }
        }
        while (k-- > 0) {
            int last = nums[0];
            for (int i = start; i < nums.length; i++) {

                int tmp = nums[i];
                nums[i] = last;
                last = tmp;

            }
            nums[start] = last;
        }
    }


    public static int gcd(int m,int n){
        int t = m%n;
        while(t!=0){
            m=n;
            n=t;
            t=m%n;
        }
        return n;
    }

    public static void rotate3(int[] nums, int k) {

        int gap = k % nums.length;
        if (gap == 0) {
            return;
        }
        // 循环次数 就是gap 和 数组长度的最大公约数
        int times;
        if (nums.length % gap == 0) {
            times = gap;
        } else {
            times = gcd(gap, nums.length);
        }

        for (int i = 0; i < times; i++) {
            int idx = i;
            int replaced = nums[idx];
            while (true) {
                int tmp = replaced;
                idx = (idx + gap) % nums.length;
                replaced = nums[idx];
                nums[idx] = tmp;
                if (idx == i) break;
            }
        }
    }





    public static void main(String[] args) {

//        int i = 6;
        for (int i = 0; i < 20; i++) {
            int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
            rotate3(arr, i);
            for (int a : arr) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
    }

}
