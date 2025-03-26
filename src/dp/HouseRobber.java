package dp;

/**
 * @author rj
 * @className HouseRobber
 * @description leetcode 198. 打家劫舍
 * @date 2025/3/26 10:28
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int robOptimized(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();

        // 测试用例 1: 基本输入
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test Case 1 - rob: " + solution.rob(nums1)); // 输出: 4
        System.out.println("Test Case 1 - robOptimized: " + solution.robOptimized(nums1)); // 输出: 4

        // 测试用例 2: 较长的数组
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Test Case 2 - rob: " + solution.rob(nums2)); // 输出: 12
        System.out.println("Test Case 2 - robOptimized: " + solution.robOptimized(nums2)); // 输出: 12

        // 测试用例 3: 只有一个元素
        int[] nums3 = {5};
        System.out.println("Test Case 3 - rob: " + solution.rob(nums3)); // 输出: 5
        System.out.println("Test Case 3 - robOptimized: " + solution.robOptimized(nums3)); // 输出: 5

        // 测试用例 4: 只有两个元素
        int[] nums4 = {2, 1};
        System.out.println("Test Case 4 - rob: " + solution.rob(nums4)); // 输出: 2
        System.out.println("Test Case 4 - robOptimized: " + solution.robOptimized(nums4)); // 输出: 2

        // 测试用例 5: 全部元素相同
        int[] nums5 = {3, 3, 3, 3, 3};
        System.out.println("Test Case 5 - rob: " + solution.rob(nums5)); // 输出: 9
        System.out.println("Test Case 5 - robOptimized: " + solution.robOptimized(nums5)); // 输出: 9

        // 测试用例 6: 包含零的数组
        int[] nums6 = {0, 0, 0, 0};
        System.out.println("Test Case 6 - rob: " + solution.rob(nums6)); // 输出: 0
        System.out.println("Test Case 6 - robOptimized: " + solution.robOptimized(nums6)); // 输出: 0

        // 测试用例 7: 单调递增数组
        int[] nums7 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 7 - rob: " + solution.rob(nums7)); // 输出: 9
        System.out.println("Test Case 7 - robOptimized: " + solution.robOptimized(nums7)); // 输出: 9

        // 测试用例 8: 单调递减数组
        int[] nums8 = {5, 4, 3, 2, 1};
        System.out.println("Test Case 8 - rob: " + solution.rob(nums8)); // 输出: 9
        System.out.println("Test Case 8 - robOptimized: " + solution.robOptimized(nums8)); // 输出: 9

        // 测试用例 9: 随机分布数组
        int[] nums9 = {10, 1, 2, 9, 5, 7};
        System.out.println("Test Case 9 - rob: " + solution.rob(nums9)); // 输出: 23
        System.out.println("Test Case 9 - robOptimized: " + solution.robOptimized(nums9)); // 输出: 23
    }
}
