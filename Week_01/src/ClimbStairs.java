
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xyx
 * @date 2020/8/25 09:51
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        //if (n == 1) {
        //    return 1;
        //}
        //if (n == 2) {
        //    return 2;
        //}
        //return climbStairs(n - 1) + climbStairs(n - 2);


        //int[] arr = new int[n + 1];
        //for (int i = 0; i <= n; i++) {
        //    if (i < 3) {
        //        arr[i] = i;
        //        continue;
        //    }
        //    arr[i] = arr[i - 1] + arr[i - 2];
        //}
        //return arr[n];


        //int a, b;
        //a = b = 0;
        //for (int i = 0; i < n; i++) {
        //    if (i < 2) {
        //        b = a;
        //        a = 1;
        //    } else {
        //        int tmp = b;
        //        b = a;
        //        a = a + tmp;
        //    }
        //}
        //return a + b;


        if (n <= 2) {
            return n;
        }
        int a = 2, b = 1;
        for (int i = 2; i < n; i++) {
            int tmp = b;
            b = a;
            a = a + tmp;
        }
        return a;

    }


    public static void main(String[] args) {




    }

}
