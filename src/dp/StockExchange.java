package dp;


/**
 * @author rj
 * @className StockExchange
 * @description leetcode 121. 买卖股票的最佳时机
 * @date 2025/3/25 17:32
 */
public class StockExchange {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    public int maxProfitOptimized(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 只需记录前一天的状态
        int dp0 = 0; // 手上没有股票时的最大利润
        int dp1 = -prices[0]; // 手上有股票时的最大利润

        for (int i = 1; i < prices.length; i++) {
            // 更新手上没有股票时的最大利润
            dp0 = Math.max(dp0, dp1 + prices[i]);
            // 更新手上有股票时的最大利润
            dp1 = Math.max(dp1, -prices[i]);
        }

        // 最后一天手上没有股票时的最大利润
        return dp0;
    }

    public int maxProfitGreedy(int[] prices){
        // 初始化最小价格为一个极大值
        int minPrice = Integer.MAX_VALUE;
        // 初始化最大利润为 0
        int maxProfit = 0;

        // 遍历价格数组
        for (int price : prices) {
            // 更新最小价格
            if (price < minPrice) {
                minPrice = price;
            } else {
                // 计算当前利润并更新最大利润
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        // 返回最大利润
        return maxProfit;
    }

    public static void main(String[] args) {
        StockExchange solution = new StockExchange();

        // 测试用例 1
        System.out.println("Test Case 1:");
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices1));
        System.out.println(solution.maxProfitOptimized(prices1));

        // 测试用例 2
        System.out.println("\nTest Case 2:");
        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices2));
        System.out.println(solution.maxProfitOptimized(prices2));

        // 测试用例 3
        System.out.println("\nTest Case 3:");
        int[] prices3 = new int[]{5};
        System.out.println(solution.maxProfit(prices3));
        System.out.println(solution.maxProfitOptimized(prices3));


        // 测试用例 4
        System.out.println("\nTest Case 4:");
        int[] prices4 = new int[]{1, 2};
        System.out.println(solution.maxProfit(prices4));
        System.out.println(solution.maxProfitOptimized(prices4));
    }
}
