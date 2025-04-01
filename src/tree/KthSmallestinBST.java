package tree;

/**
 * @author rj
 * @className KthSmallestinBST
 * @description leetcode 230. 二叉搜索树中第 K 小的元素
 * @date 2025/3/31 10:30
 */
public class KthSmallestinBST {
    private int index = 0; // 显式初始化
    private int result = 0; // 存储结果

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // 遍历左子树
        inorderTraversal(node.left, k);
        // 处理当前节点
        index++;
        if (index == k) {
            result = node.val;
            return; // 提前终止遍历
        }
        // 遍历右子树
        inorderTraversal(node.right, k);
    }
}
