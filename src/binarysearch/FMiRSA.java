package binarysearch;

/**
 * @author rj
 * @className FMiRSA
 * @description leetcode 153. 寻找旋转排序数组中的最小值
 * @date 2025/4/2 9:42
 */
public class FMiRSA {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
