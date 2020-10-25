/**
 * 190. 颠倒二进制位
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author xyx
 * @date 2020/10/25 17:41
 */
public class LeetCode190 {


    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = ret << 1;
            if ((n & 1) == 1) ret += 1;
            n = n >> 1;
        }
        return ret;
    }



    public static void main(String[] args) {
        System.out.println(new LeetCode190().reverseBits(281));
    }


}
