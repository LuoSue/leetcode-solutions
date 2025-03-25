package binarysearch;

/**
 * @author rj
 * @className FFaLPoEiSA
 * @description leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date 2025/3/24 11:25
 */
public class FFaLPoEiSA {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // 找到左边界
        result[0] = findLeft(nums, target);

        // 找到右边界
        result[1] = findRight(nums, target);

        return result;
    }

    // 寻找左边界
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] >= target) { // 目标值可能在左侧
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 检查是否找到目标值
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    // 寻找右边界
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] <= target) { // 目标值可能在右侧
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 检查是否找到目标值
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        FFaLPoEiSA solution = new FFaLPoEiSA();

        // 示例 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // 输出 [3, 4]

        // 示例 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // 输出 [-1, -1]

        // 示例 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // 输出 [-1, -1]
    }
}
