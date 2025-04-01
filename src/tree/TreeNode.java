package tree;

/**
 * @author rj
 * @className TreeNode
 * @description 二叉树节点类
 * @date 2025/3/30 11:21
 */
public class TreeNode {
    // 节点值
    public int val;

    // 左子节点
    public TreeNode left;

    // 右子节点
    public TreeNode right;

    /**
     * 无参构造函数 - 创建一个空节点
     */
    public TreeNode() {
        // 默认值初始化
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    /**
     * 带值构造函数 - 创建一个带有指定值的节点
     * @param val 节点值
     */
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * 完整构造函数 - 创建一个带有值、左右子节点的节点
     * @param val 节点值
     * @param left 左子节点
     * @param right 右子节点
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据数组构建二叉树
     * @param arr 数组表示二叉树，按层序遍历，null表示空节点
     * @return 构建好的二叉树根节点
     */
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    /**
     * 层序遍历二叉树并返回字符串表示
     * @return 二叉树的层序遍历字符串
     */
    public String levelOrderString() {
        StringBuilder sb = new StringBuilder("[");
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

                if (!queue.isEmpty() || i < levelSize - 1) {
                    sb.append(", ");
                }
            }
        }

        // 移除末尾多余的null
        while (sb.length() > 5 && sb.substring(sb.length() - 5).equals("null, ")) {
            sb.delete(sb.length() - 5, sb.length());
        }
        while (sb.length() > 4 && sb.substring(sb.length() - 4).equals("null")) {
            sb.delete(sb.length() - 4, sb.length());
        }
        while (sb.length() > 2 && sb.substring(sb.length() - 2).equals(", ")) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + "}";
    }
}
