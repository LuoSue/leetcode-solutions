package tree;

/**
 * @author rj
 * @className LCAofBT
 * @description leetcode 236. 二叉树的最近公共祖先
 * @date 2025/3/31 14:00
 */
public class LCAofBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基本情况：如果root为null或者root是p或q中的一个，返回root
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归在左子树和右子树中查找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树都返回非null，说明当前节点是LCA
        if (left != null && right != null) {
            return root;
        }

        // 否则返回非null的那一侧的结果
        return left != null ? left : right;
    }
}
