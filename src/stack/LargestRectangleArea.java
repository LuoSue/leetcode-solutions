package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rj
 * @className LRiH
 * @description leetcode 84. 柱状图中最大的矩形
 * @date 2025/3/25 10:30
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈，存储柱子的索引
        int maxArea = 0; // 最大面积

        for (int i = 0; i <= n; i++) {
            // 当前柱子的高度（在末尾添加一个虚拟柱子，高度为 0）
            int currentHeight = (i == n) ? 0 : heights[i];

            // 如果当前柱子的高度小于栈顶柱子的高度，计算面积
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // 弹出栈顶柱子
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // 计算宽度
                maxArea = Math.max(maxArea, height * width); // 更新最大面积
            }

            // 当前柱子入栈
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleArea solution = new LargestRectangleArea();

        // 测试用例 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights1)); // 输出 10

        // 测试用例 2
        int[] heights2 = {2, 4};
        System.out.println(solution.largestRectangleArea(heights2)); // 输出 4

        // 测试用例 3
        int[] heights3 = {2, 1, 2};
        System.out.println(solution.largestRectangleArea(heights3)); // 输出 3

        // 测试用例 4
        int[] heights4 = {5, 4, 3, 2, 1};
        System.out.println(solution.largestRectangleArea(heights4)); // 输出 9
    }
}
