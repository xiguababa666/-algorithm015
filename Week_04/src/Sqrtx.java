/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author xyx
 * @date 2020/9/19 18:41
 */
public class Sqrtx {


    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(99));
    }


    public int mySqrt(int x) {
        if (x < 2) return x;
        double l = 0, r = x;
        while (l < r) {
            double mid = (l + r) / 2;
            double s = mid * mid;
            if (Math.abs(s - x) < 0.00001) {
                int round = (int) Math.round(mid);
                if (round * round == x) return round;
                else return (int) mid;
            }
            if (s > x) r = mid;
            else l = mid;
        }
        return 0;
    }

}
