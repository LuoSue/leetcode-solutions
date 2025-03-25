package binarysearch;

import java.util.List;

/**
 * @author rj
 * @className SiRSA
 * @description leetcode 33. 搜索旋转排序数组
 * @date 2025/3/24 11:37
 */
public class SiRSA {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 如果找到目标值，直接返回下标
            if (nums[mid] == target) {
                return mid;
            }

            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 如果目标值在左半部分范围内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // 缩小搜索范围到左半部分
                } else {
                    left = mid + 1; // 否则搜索右半部分
                }
            }
            // 否则右半部分有序
            else {
                // 如果目标值在右半部分范围内
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // 缩小搜索范围到右半部分
                } else {
                    right = mid - 1; // 否则搜索左半部分
                }
            }
        }

        // 如果没有找到目标值，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        SiRSA solution = new SiRSA();

        // 示例 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(solution.search(nums1, target1)); // 输出: 4

        // 示例 2
        int target2 = 3;
        System.out.println(solution.search(nums1, target2)); // 输出: -1

        // 示例 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(solution.search(nums3, target3)); // 输出: -1
    }
}
