package tree;

/**
 * @author rj
 * @className SymmetricTree
 * @description leetcode 101. 对称二叉树
 * @date 2025/3/30 12:07
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }

        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }
}
