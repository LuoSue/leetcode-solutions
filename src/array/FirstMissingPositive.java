package array;

/**
 * @author rj
 * @className FirstMissingPositive
 * @description leetcode 41. 缺失的第一个正数
 * @date 2025/3/28 10:17
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将数字放置到正确的位置
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                swap(nums, i, nums[i] - 1);
            }
        }

        // 找到第一个不匹配的索引
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有的数字都在正确的位置上，则返回 n + 1
        return n + 1;
    }

    // 辅助函数，用于交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();

        // 测试用例
        int[] nums1 = {1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums1)); // 预期输出: 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums2)); // 预期输出: 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums3)); // 预期输出: 1

        int[] nums4 = {1, 1};
        System.out.println(solution.firstMissingPositive(nums4)); // 预期输出: 2
    }
}
