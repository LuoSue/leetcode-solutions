package tree;

/**
 * @author rj
 * @className DiameterTree
 * @description leetcode 543. 二叉树的直径
 * @date 2025/3/30 12:11
 */
public class DiameterTree {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depth(root);
        return result - 1;
    }

    private int depth(TreeNode root){
        if (root == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(root.left); // 左儿子为根的子树的深度
        int R = depth(root.right); // 右儿子为根的子树的深度
        result = Math.max(result, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
