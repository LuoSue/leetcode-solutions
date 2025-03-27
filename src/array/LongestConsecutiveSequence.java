package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rj
 * @className LongestConsecutiveSequence
 * @description leetcode 128. 最长连续序列
 * @date 2025/3/27 11:17
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 使用Set去重并实现O(1)时间复杂度的查找
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // 只有当当前数字是一个序列的起点时才进行处理
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 向后查找连续的数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最大长度
                longestStreak = Math.max(longestStreak, currentStreak);

                // 提前终止条件：如果已经找到可能的最大序列
                if (longestStreak > numSet.size() / 2) {
                    break;
                }
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // 测试用例1：普通情况
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("测试1结果: " + solution.longestConsecutive(nums1)); // 期望输出: 4

        // 测试用例2：空数组
        int[] nums2 = {};
        System.out.println("测试2结果: " + solution.longestConsecutive(nums2)); // 期望输出: 0

        // 测试用例3：所有元素相同
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("测试3结果: " + solution.longestConsecutive(nums3)); // 期望输出: 1

        // 测试用例4：包含负数
        int[] nums4 = {0, -1, -2, 5, 6, 7};
        System.out.println("测试4结果: " + solution.longestConsecutive(nums4)); // 期望输出: 3

        // 测试用例5：大数测试
        int[] nums5 = {2147483646, -2147483647, 0, 2, 2147483644, -2147483646, 2147483645};
        System.out.println("测试5结果: " + solution.longestConsecutive(nums5)); // 期望输出: 3
    }
}
