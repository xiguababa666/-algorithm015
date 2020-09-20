import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 *
 * @author xyx
 * @date 2020/9/17 21:26
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si++] >= g[gi]) gi++;
        }
        return gi;
    }

}
