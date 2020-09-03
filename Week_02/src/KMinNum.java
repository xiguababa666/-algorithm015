import java.util.Arrays;

/**
 *
 * 40. 最小的k个数
 *
 * */

public class KMinNum {


    public static void main(String[] args) {
        int[]  r = new KMinNum().getLeastNumbers(new int[] {1,2,3,4,5,6,7,8,9}, 5);

        for (int i : r) {
            System.out.println(i + ",");
        }
    }

    /**
     * 堆排序
     * */
    public int[] getLeastNumbers(int[] arr, int k) {

        int[] ret = Arrays.copyOfRange(arr, 0, k);
        buildHeap(ret);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] >= ret[0]) continue;
            ret[0] = arr[i];
            heapify(ret);
        }

        return ret;

    }

    private void heapify(int[] arr) {
        // todo
    }


    /**
     * */
    private void buildHeap(int[] arr) {

        //              1
        //         8          2
        //      7     4    3      6
        //    5


    }



}
