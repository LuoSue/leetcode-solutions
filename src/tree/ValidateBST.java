package tree;

/**
 * @author rj
 * @className ValidateBST
 * @description leetcode 98. 验证二叉搜索树
 * @date 2025/3/31 10:27
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        // 检查当前节点值是否在允许范围内
        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper)) {
            return false;
        }

        // 递归检查左右子树
        // 左子树的上界变为当前节点值
        // 右子树的下界变为当前节点值
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
