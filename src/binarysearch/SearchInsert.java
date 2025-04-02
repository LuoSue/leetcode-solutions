package binarysearch;

/**
 * @author rj
 * @className SearchInsert
 * @description leetcode 35. 搜索插入位置
 * @date 2025/4/2 9:32
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }
}
