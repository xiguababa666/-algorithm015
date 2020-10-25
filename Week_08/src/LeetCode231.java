/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * @author xyx
 * @date 2020/10/25 17:24
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode231().isPowerOfTwo(65536));
    }


}
