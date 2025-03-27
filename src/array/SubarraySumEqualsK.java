package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className SubarraySumEqualsK
 * @description leetcode 560. 和为 K 的子数组
 * @date 2025/3/27 15:01
 */
public class SubarraySumEqualsK {
    /**
     * 前缀和法：计算和为 K 的子数组数量。
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; // 处理空数组或null输入
        }

        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);  // 初始化，前缀和为0的次数为1

        for (int num : nums) {
            currentSum += num;

            // 检查是否存在一个前缀和，使得 currentSum - k 在哈希表中
            if (sumCountMap.containsKey(currentSum - k)) {
                count += sumCountMap.get(currentSum - k);
            }

            // 更新哈希表
            sumCountMap.put(currentSum, sumCountMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();

        // 测试用例
        System.out.println(solver.subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println(solver.subarraySum(new int[]{1}, 1));       // 1
        System.out.println(solver.subarraySum(new int[]{1, 2, 3}, 7)); // 0
        System.out.println(solver.subarraySum(new int[]{}, 0));        // 0
    }
}