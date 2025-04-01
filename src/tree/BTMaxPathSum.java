package tree;

/**
 * @author rj
 * @className BTMaxPathSum
 * @description leetcode 124. 二叉树中的最大路径和
 * @date 2025/3/31 14:04
 */
public class BTMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 当前节点的路径和（可能作为路径的根节点）
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新全局最大值
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回当前节点的最大贡献值（只能选择一边）
        return node.val + Math.max(leftGain, rightGain);
    }
}
