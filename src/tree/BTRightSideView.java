package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className BTRightSideView
 * @description leetcode 199. 二叉树的右视图
 * @date 2025/3/31 10:36
 */
public class BTRightSideView {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(node.val);
        }
        dfs(node.right, level + 1);  // 先右后左
        dfs(node.left, level + 1);
    }
}
