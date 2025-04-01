package tree;

/**
 * @author rj
 * @className FlattenBT
 * @description leetcode 114. 二叉树展开为链表
 * @date 2025/3/31 13:43
 */
public class FlattenBT {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while(current.right != null){
            current = current.right;
        }
        current.right = tempRight;
    }
}
