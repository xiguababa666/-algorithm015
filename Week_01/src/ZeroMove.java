
/**
 * description
 *
 * @author xyx
 * @date 2020/8/24 19:40
 */
public class ZeroMove {

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int idxZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[idxZero] == 0) {
                    nums[idxZero] = nums[i];
                    nums[i] = 0;
                }
                idxZero++;
            }
        }




        //if (nums == null || nums.length == 0) {
        //    return;
        //}
        //
        //int idxA, idxB;
        //idxA = idxB = 0;
        //
        //while (idxB < nums.length) {
        //    if (nums[idxB] != 0) {
        //        if (nums[idxA] == 0) {
        //            nums[idxA] = nums[idxB];
        //            nums[idxB] = 0;
        //        }
        //        idxA++;
        //    }
        //    idxB++;
        //}





        //int length;
        //if ((length = nums.length) == 0) return;
        //int k = 0;
        //for (int i = 0; i < length; ++i) {
        //    if (nums[i] != 0) {
        //        if (k < i) {
        //            nums[k] = nums[i];
        //            nums[i] = 0;
        //        }
        //        k++;
        //    }
        //}
    }


    public static void main(String[] args) {

        int[] arr = new int[] {0,1,0,0,2,3,0,4,0,0,0,5,6,0,7,8};

        new ZeroMove().moveZeroes(arr);

        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }

    }

}
