package dp;

import java.util.Arrays;

/**
 * @author rj
 * @className PerfectSquares
 * @description leetcode 279. 完全平方数
 * @date 2025/3/26 10:48
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // 创建 dp 数组并初始化
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1); // 初始化为最大值（n + 1 是一个不可能达到的上界）
        dp[0] = 0; // 边界条件：和为 0 时需要 0 个完全平方数

        // 填充 dp 数组
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }

        return dp[n]; // 返回结果
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();

        // 测试用例
        System.out.println(solution.numSquares(12)); // 输出: 3 (4 + 4 + 4)
        System.out.println(solution.numSquares(13)); // 输出: 2 (4 + 9)
        System.out.println(solution.numSquares(1));  // 输出: 1 (1)
        System.out.println(solution.numSquares(7));  // 输出: 4 (4 + 1 + 1 + 1)
        System.out.println(solution.numSquares(100)); // 输出: 1 (100 是完全平方数)
    }
}
