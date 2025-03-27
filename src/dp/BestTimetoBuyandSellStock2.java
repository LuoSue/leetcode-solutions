package dp;

/**
 * @author rj
 * @className BestTimetoBuyandSellStock2
 * @description leetcode 122. 买卖股票的最佳时机 II
 * @date 2025/3/27 11:55
 */
public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        // 初始化总利润为0
        int profit = 0;
        // 遍历数组中每个元素
        for(int i = 1; i < prices.length; i++)
        {
            // 如果后一天比前一天高，则进行交易，并累加利润
            if(prices[i] > prices[i-1])
            {
                profit += prices[i] - prices[i-1];
            }
        }
        // 返回总利润
        return profit;
    }
}
