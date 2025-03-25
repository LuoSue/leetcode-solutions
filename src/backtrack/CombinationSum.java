package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className CombinationSum
 * @description leetcode 39. 组合总和
 * @date 2025/3/24 10:11
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 存储最终结果的列表
        List<List<Integer>> result = new ArrayList<>();
        // 存储当前路径的列表
        List<Integer> path = new ArrayList<>();
        // 调用回溯函数
        backtrack(candidates, target, 0, 0, path, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, int currentSum, List<Integer> path, List<List<Integer>> result) {
        // 如果当前和等于目标值，将当前路径加入结果
        if (currentSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 如果当前和超过目标值，直接返回（剪枝）
        if (currentSum > target) {
            return;
        }
        // 遍历候选数字
        for (int i = start; i < candidates.length; i++) {
            // 选择当前数字
            path.add(candidates[i]);
            // 递归调用，注意 start 参数保持为 i，允许重复选择当前数字
            backtrack(candidates, target, i, currentSum + candidates[i], path, result);
            // 撤销选择（回溯）
            path.remove(path.size() - 1);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(solution.combinationSum(candidates1, target1)); // 输出：[[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(solution.combinationSum(candidates2, target2)); // 输出：[[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(solution.combinationSum(candidates3, target3)); // 输出：[]
    }
}
