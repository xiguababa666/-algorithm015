import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 *
 * @author xyx
 * @date 2020/9/16 17:19
 */
public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println(new LemonadeChange().lemonadeChange(new int[] {5,5,5,10,20}));
    }


    public boolean lemonadeChange(int[] bills) {

        if (bills == null || bills.length == 0) return true;
        if (bills[0] > 5) return false;

        int five = 0, ten = 0;
        for (int a : bills) {
            if (a == 5) {
                five++;
            } else if (a == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }


}
