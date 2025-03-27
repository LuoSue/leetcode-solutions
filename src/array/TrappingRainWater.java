package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rj
 * @className TrappingRainWater
 * @description leetcode 42. 接雨水
 * @date 2025/3/27 14:46
 */
public class TrappingRainWater {
    /**
     * 双指针法：计算能接的雨水总量。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0; // 无法接雨水
        }

        int left = 0;
        int right = height.length - 1;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public int trapDynamicProgramming(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public int trapMonotonicStack(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int totalWater = 0;
        int current = 0;

        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                totalWater += distance * boundedHeight;
            }
            stack.push(current++);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();

        // 测试用例
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solver.trap(height1)); // 6

        int[] height2 = {2, 0, 2};
        System.out.println(solver.trap(height2)); // 2

        int[] height3 = {1, 2, 3};
        System.out.println(solver.trap(height3)); // 0

        int[] height4 = {0, 0, 0};
        System.out.println(solver.trap(height4)); // 0

        int[] height5 = {};
        System.out.println(solver.trap(height5)); // 0
    }
}
