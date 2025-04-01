package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className PreorderInorderTree
 * @description leetcode 105. 从前序与中序遍历序列构造二叉树
 * @date 2025/3/31 13:46
 */
public class PreorderInorderTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = indexMap.get(rootVal);
        int leftSubtreeSize = inRoot - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, inRoot - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}
