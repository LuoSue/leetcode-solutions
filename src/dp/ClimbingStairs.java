package dp;

/**
 * @author rj
 * @className ClimbingStairs
 * @description leetcode 70. 爬楼梯
 * @date 2025/3/25 16:49
 */
public class ClimbingStairs {

    /**
     * 解法一：动态规划（使用数组存储中间结果）
     * <p>
     * 使用一个数组 dp 来存储每一步的结果：
     * - dp[i] 表示到达第 i 阶楼梯的方法总数。
     * - 状态转移方程：dp[i] = dp[i-1] + dp[i-2]
     *   因为每次可以爬 1 阶或 2 阶，因此到达第 i 阶的方法数是到达第 i-1 阶和第 i-2 阶的方法数之和。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n 楼梯的阶数
     * @return 到达第 n 阶楼梯的方法总数
     */
    public int climbStairsWithArray(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 创建一个数组存储每一步的结果
        int[] dp = new int[n];
        dp[0] = 1; // 到达第 1 阶的方法数
        dp[1] = 2; // 到达第 2 阶的方法数

        // 填充数组
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回到达第 n 阶的方法数
        return dp[n - 1];
    }

    /**
     * 解法二：动态规划（优化空间复杂度）
     * <p>
     * 在解法一的基础上优化了空间复杂度：
     * - 不需要使用数组存储所有中间结果，只需要两个变量 prev1 和 prev2 分别表示前两步的结果。
     * - 状态转移方程：current = prev1 + prev2
     *   其中 current 是当前步的结果，prev1 是前一步的结果，prev2 是前两步的结果。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n 楼梯的阶数
     * @return 到达第 n 阶楼梯的方法总数
     */
    public int climbStairsOptimized(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 初始化前两步的结果
        int prev1 = 2; // 到达第 2 阶的方法数
        int prev2 = 1; // 到达第 1 阶的方法数

        // 计算从第 3 阶到第 n 阶的结果
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2; // 当前步的结果
            prev2 = prev1; // 更新 prev2 为前一步的结果
            prev1 = current; // 更新 prev1 为当前步的结果
        }

        // 返回到达第 n 阶的方法数
        return prev1;
    }

    /**
     * 主函数：测试两种方法的结果
     */
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        // 测试用例 1：最小输入
        int n1 = 1;
        System.out.println("Test Case 1 (n = " + n1 + "):");
        System.out.println("climbStairsWithArray: " + solution.climbStairsWithArray(n1));
        System.out.println("climbStairsOptimized: " + solution.climbStairsOptimized(n1));

        // 测试用例 2：小规模输入
        int n2 = 5;
        System.out.println("\nTest Case 2 (n = " + n2 + "):");
        System.out.println("climbStairsWithArray: " + solution.climbStairsWithArray(n2));
        System.out.println("climbStairsOptimized: " + solution.climbStairsOptimized(n2));

        // 测试用例 3：中等规模输入
        int n3 = 10;
        System.out.println("\nTest Case 3 (n = " + n3 + "):");
        System.out.println("climbStairsWithArray: " + solution.climbStairsWithArray(n3));
        System.out.println("climbStairsOptimized: " + solution.climbStairsOptimized(n3));

        // 测试用例 4：大规模输入
        int n4 = 45;
        System.out.println("\nTest Case 4 (n = " + n4 + "):");
        System.out.println("climbStairsWithArray: " + solution.climbStairsWithArray(n4));
        System.out.println("climbStairsOptimized: " + solution.climbStairsOptimized(n4));
    }
}
