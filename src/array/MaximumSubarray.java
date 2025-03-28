package array;

/**
 * @author rj
 * @className MaximumSubarray
 * @description leetcode 53. 最大子数组和
 * @date 2025/3/28 10:00
 */
public class MaximumSubarray {
    // 方法1：分治法
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 包含中间的左半部分最大和
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += nums[i];
            if (currentSum > leftSum) {
                leftSum = currentSum;
            }
        }

        // 包含中间的右半部分最大和
        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            if (currentSum > rightSum) {
                rightSum = currentSum;
            }
        }

        // 返回跨越中间的最大和
        return leftSum + rightSum;
    }

    private int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {
        // 基本情况：当只有一个元素时
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        // 分别递归求解左半部分、右半部分和跨越中间的子数组最大值
        int leftMax = maxSubArrayDivideAndConquer(nums, left, mid);
        int rightMax = maxSubArrayDivideAndConquer(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);

        // 返回三个部分的最大值
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    // 方法2：动态规划（Kadane算法）
    public int maxSubArrayKadane(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    // 方法3：暴力法（不推荐用于大规模数据）
    public int maxSubArrayBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("分治法结果: " + solution.maxSubArrayDivideAndConquer(nums));
        System.out.println("Kadane算法结果: " + solution.maxSubArrayKadane(nums));
        System.out.println("暴力法结果: " + solution.maxSubArrayBruteForce(nums));
    }
}