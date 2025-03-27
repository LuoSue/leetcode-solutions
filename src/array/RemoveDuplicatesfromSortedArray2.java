package array;

/**
 * @author rj
 * @className RemoveDuplicatesfromSortedArray2
 * @description leetcode 80. 删除有序数组中的重复项 II
 * @date 2025/3/27 11:30
 */
public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newLength = 1;  // 新数组长度，初始为1（第一个元素肯定保留）
        int duplicateCount = 1;  // 当前数字的重复次数

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicateCount++;
            } else {
                duplicateCount = 1;  // 遇到新数字，重置计数器
            }

            // 只有当重复次数不超过2时才保留该数字
            if (duplicateCount <= 2) {
                nums[newLength] = nums[i];
                newLength++;
            }
        }

        return newLength;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray2 solution = new RemoveDuplicatesfromSortedArray2();

        // 测试用例1：普通情况
        int[] nums1 = {1,1,1,2,2,3};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("测试1结果: " + len1 + ", 数组: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();  // 期望: 5, [1,1,2,2,3]

        // 测试用例2：所有元素相同
        int[] nums2 = {1,1,1,1,1};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("测试2结果: " + len2 + ", 数组: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();  // 期望: 2, [1,1]

        // 测试用例3：无重复元素
        int[] nums3 = {1,2,3,4,5};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("测试3结果: " + len3 + ", 数组: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();  // 期望: 5, [1,2,3,4,5]

        // 测试用例4：空数组
        int[] nums4 = {};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("测试4结果: " + len4 + ", 数组: ");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println();  // 期望: 0, []

        // 测试用例5：刚好2个重复
        int[] nums5 = {1,1,2,2,3,3};
        int len5 = solution.removeDuplicates(nums5);
        System.out.print("测试5结果: " + len5 + ", 数组: ");
        for (int i = 0; i < len5; i++) {
            System.out.print(nums5[i] + " ");
        }
        System.out.println();  // 期望: 6, [1,1,2,2,3,3]
    }
}
