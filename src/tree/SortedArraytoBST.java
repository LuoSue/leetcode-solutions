package tree;

/**
 * @author rj
 * @className SortedArraytoBST
 * @description leetcode 108. 将有序数组转换为二叉搜索树
 * @date 2025/3/30 12:16
 */
public class SortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择中间位置作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左右子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
