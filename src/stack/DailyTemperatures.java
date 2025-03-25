package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rj
 * @className DailyTemperatures
 * @description leetcode 739. 每日温度
 * @date 2025/3/25 10:09
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n]; // 结果数组，存储每个位置的答案
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈，存储温度的索引

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i]; // 当前温度

            // 如果栈不为空，且当前温度大于栈顶索引对应的温度
            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                int idx = stack.pop(); // 弹出栈顶索引
                ans[idx] = i - idx; // 计算天数差
            }
            stack.push(i); // 将当前索引入栈
        }

        return ans; // 返回结果数组
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // 测试用例 1：普通情况
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println(java.util.Arrays.toString(result1)); // 输出 [1, 1, 4, 2, 1, 1, 0, 0]

        // 测试用例 2：递增序列
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println(java.util.Arrays.toString(result2)); // 输出 [1, 1, 1, 0]

        // 测试用例 3：递减序列
        int[] temperatures3 = {60, 50, 40, 30};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println(java.util.Arrays.toString(result3)); // 输出 [0, 0, 0, 0]

        // 测试用例 4：只有一个元素
        int[] temperatures4 = {30};
        int[] result4 = solution.dailyTemperatures(temperatures4);
        System.out.println(java.util.Arrays.toString(result4)); // 输出 [0]
    }
}
