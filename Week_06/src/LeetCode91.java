/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author xyx
 * @date 2020/9/28 21:28
 */
public class LeetCode91 {


    public static void main(String[] args) {
        System.out.println(new LeetCode91().numDecodings("10"));
    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        if (len == 1) return 1;

        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            char cc = s.charAt(i);
            char lc = s.charAt(i - 1);
            if (cc == '0') {
                if (lc == '0' || lc > '2') return 0;
                else dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (lc == '0' || lc > '2')
                dp[i] = dp[i - 1];
            else if (lc == '1' || cc <= '6')
                dp[i] = dp[i - 1] + (i == 1 ? 1 : dp[i - 2]);
            else
                dp[i] = dp[i - 1];

        }
        return dp[dp.length - 1];
    }

}
