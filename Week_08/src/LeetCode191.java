/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 *
 * @author xyx
 * @date 2020/10/25 16:44
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        //int count = 0;
        //do {
        //    System.out.println(Integer.toBinaryString(n));
        //    if ((n & 1) == 1) count++;
        //} while ((n = n >>> 1) != 0);
        //return count;


        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        //System.out.println(-4 >>> 2);

        System.out.println(new LeetCode191().hammingWeight(-16));
    }

}
