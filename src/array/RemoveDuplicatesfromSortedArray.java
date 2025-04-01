package array;

/**
 * @author rj
 * @className RemoveDuplicatesfromSortedArray
 * @description leetcode 26. 删除有序数组中的重复项
 * @date 2025/4/1 9:56
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++)
        {
            if(nums[fast]!=nums[slow])
            {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
