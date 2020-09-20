/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @author xyx
 * @date 2020/9/19 13:49
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) return profit;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

}
