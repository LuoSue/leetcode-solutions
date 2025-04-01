package tree;

/**
 * @author rj
 * @className MaxDepth
 * @description leetcode 104. 二叉树的最大深度
 * @date 2025/3/30 11:34
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();

        TreeNode tree = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(solution.maxDepth(tree));
    }
}
