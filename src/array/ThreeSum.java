package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rj
 * @className ThreeSum
 * @description leetcode 15. 三数之和
 * @date 2025/3/27 14:44
 */
public class ThreeSum {
    /**
     * 找出所有不重复的三元组，使得它们的和为 0。
     * 时间复杂度：O(n^2)，空间复杂度：O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result; // 无法形成三元组
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // 提前终止：当前数大于0，后面的数不可能和为0
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复的数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 优化：如果当前数加上最大的两个数仍小于0，跳过
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复的左指针元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过重复的右指针元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        // 测试用例
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solver.threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {1, 2, 3};
        System.out.println(solver.threeSum(nums2)); // []

        int[] nums3 = {0, 0, 0};
        System.out.println(solver.threeSum(nums3)); // [[0, 0, 0]]

        int[] nums4 = {};
        System.out.println(solver.threeSum(nums4)); // []

        int[] nums5 = {1, 2};
        System.out.println(solver.threeSum(nums5)); // []
    }
}