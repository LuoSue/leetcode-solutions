package tree;

import java.util.*;

/**
 * @author rj
 * @className BinaryTreeTraversal
 * @description 二叉树遍历实现类
 * @date 2025/3/30 11:24
 */
public class BinaryTreeTraversal {
    /**
     * 前序遍历（递归）
     * @param root 二叉树根节点
     * @return 前序遍历结果列表
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);       // 访问根节点
        preorderHelper(node.left, result);  // 遍历左子树
        preorderHelper(node.right, result); // 遍历右子树
    }

    /**
     * 前序遍历（迭代）
     * @param root 二叉树根节点
     * @return 前序遍历结果列表
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // 先压入右节点，再压入左节点，这样出栈顺序就是左->右
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    /**
     * 中序遍历（递归）
     * @param root 二叉树根节点
     * @return 中序遍历结果列表
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);  // 遍历左子树
        result.add(node.val);       // 访问根节点
        inorderHelper(node.right, result); // 遍历右子树
    }

    /**
     * 中序遍历（迭代）
     * @param root 二叉树根节点
     * @return 中序遍历结果列表
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;  // 一直向左走到底
            }
            curr = stack.pop();
            result.add(curr.val);  // 访问节点
            curr = curr.right;     // 转向右子树
        }

        return result;
    }

    /**
     * 后序遍历（递归）
     * @param root 二叉树根节点
     * @return 后序遍历结果列表
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);  // 遍历左子树
        postorderHelper(node.right, result); // 遍历右子树
        result.add(node.val);       // 访问根节点
    }

    /**
     * 后序遍历（迭代）
     * @param root 二叉树根节点
     * @return 后序遍历结果列表
     */
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            // 如果当前节点是叶子节点或已经处理过其子节点
            if ((curr.left == null && curr.right == null) ||
                    (prev != null && (prev == curr.left || prev == curr.right))) {
                result.add(curr.val);
                stack.pop();
                prev = curr;
            } else {
                // 先压入右节点，再压入左节点
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }

        return result;
    }

    /**
     * 层序遍历（迭代）
     * @param root 二叉树根节点
     * @return 层序遍历结果列表
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();

        // 构建测试二叉树
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        Integer[] treeArr = {1, 2, 3, 4, 5, null, 6};
        TreeNode root = TreeNode.buildTree(treeArr);

        // 测试各种遍历
        System.out.println("前序遍历(递归): " + traversal.preorderTraversalRecursive(root));
        System.out.println("前序遍历(迭代): " + traversal.preorderTraversalIterative(root));
        System.out.println("中序遍历(递归): " + traversal.inorderTraversalRecursive(root));
        System.out.println("中序遍历(迭代): " + traversal.inorderTraversalIterative(root));
        System.out.println("后序遍历(递归): " + traversal.postorderTraversalRecursive(root));
        System.out.println("后序遍历(迭代): " + traversal.postorderTraversalIterative(root));
        System.out.println("层序遍历: " + traversal.levelOrderTraversal(root));
    }
}
