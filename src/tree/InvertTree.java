package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rj
 * @className InvertTree
 * @description leetcode 226. 翻转二叉树
 * @date 2025/3/30 11:50
 */
public class InvertTree {
    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }

        swapNode(root);
        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);

        return root;
    }


    public TreeNode invertTreeQueue(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            swapNode(current);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return root;
    }

    private void swapNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        InvertTree solution = new InvertTree();

        Integer[] nums1 = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root1 = TreeNode.buildTree(nums1);
        System.out.println(solution.invertTreeQueue(root1).levelOrderString());
    }
}
