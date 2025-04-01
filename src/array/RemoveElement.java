package array;

/**
 * @author rj
 * @className RemoveElement
 * @description leetcode 27. 移除元素
 * @date 2025/4/1 9:55
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
