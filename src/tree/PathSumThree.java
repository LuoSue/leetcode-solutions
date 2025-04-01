package tree;

import java.util.HashMap;

/**
 * @author rj
 * @className PathSumThree
 * @description leetcode 437. 路径总和 III
 * @date 2025/3/31 13:57
 */
public class PathSumThree {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // 初始前缀和为0出现1次
        return helper(root, 0L, targetSum, prefixSumCount);
    }

    private int helper(TreeNode node, long currentSum, int target, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        // 查看是否有前缀和等于currentSum - target
        int res = prefixSumCount.getOrDefault(currentSum - target, 0);

        // 更新当前前缀和的计数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // 递归处理左右子树
        res += helper(node.left, currentSum, target, prefixSumCount);
        res += helper(node.right, currentSum, target, prefixSumCount);

        // 回溯，恢复前缀和计数
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return res;
    }
}
