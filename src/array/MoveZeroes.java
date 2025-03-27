package array;

/**
 * @author rj
 * @className MoveZeroes
 * @description leetcode 283. 移动零（双指针法）
 * @date 2025/3/27 14:33
 */
public class MoveZeroes {
    /**
     * 移动零到数组末尾，保持非零元素的相对顺序。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return; // 处理空数组或null输入
        }

        int nonZeroPointer = 0; // 指向当前非零元素应放置的位置
        for (int currentPointer = 0; currentPointer < nums.length; currentPointer++) {
            if (nums[currentPointer] != 0) {
                nums[nonZeroPointer++] = nums[currentPointer]; // 非零元素前移
            }
        }

        // 将剩余位置补零
        while (nonZeroPointer < nums.length) {
            nums[nonZeroPointer++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mover = new MoveZeroes();

        // 测试用例
        int[] nums1 = {0, 1, 0, 3, 12};
        mover.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // [1, 3, 12, 0, 0]

        int[] nums2 = {0, 0, 0};
        mover.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // [0, 0, 0]

        int[] nums3 = {1, 2, 3};
        mover.moveZeroes(nums3);
        System.out.println(java.util.Arrays.toString(nums3)); // [1, 2, 3]

        int[] nums4 = {};
        mover.moveZeroes(nums4);
        System.out.println(java.util.Arrays.toString(nums4)); // []
    }
}