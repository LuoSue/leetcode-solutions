package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className TwoSum
 * @description leetcode 1. 两数之和
 * @date 2025/3/27 10:46
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // 示例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("示例 1 结果: " + Arrays.toString(result1));  // 期望输出: [0, 1]

        // 示例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("示例 2 结果: " + Arrays.toString(result2));  // 期望输出: [1, 2]

        // 示例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("示例 3 结果: " + Arrays.toString(result3));  // 期望输出: [0, 1]

        // 示例 4（无解情况）
        int[] nums4 = {1, 2, 3};
        int target4 = 7;
        try {
            int[] result4 = solution.twoSum(nums4, target4);
            System.out.println("示例 4 结果: " + Arrays.toString(result4));
        } catch (IllegalArgumentException e) {
            System.out.println("示例 4 结果: " + e.getMessage());  // 期望输出: No two sum solution
        }
    }
}
