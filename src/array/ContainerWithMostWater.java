package array;

/**
 * @author rj
 * @className ContainerWithMostWater
 * @description leetcode 11. 盛最多水的容器（双指针法）
 * @date 2025/3/27 14:40
 */
public class ContainerWithMostWater {
    /**
     * 计算能盛最多水的容器面积。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0; // 无法形成容器
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = minHeight * width;
            maxArea = Math.max(maxArea, currentArea);

            // 移动较短的边界
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        // 测试用例
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solver.maxArea(height1)); // 49

        int[] height2 = {1, 1};
        System.out.println(solver.maxArea(height2)); // 1

        int[] height3 = {1};
        System.out.println(solver.maxArea(height3)); // 0

        int[] height4 = {};
        System.out.println(solver.maxArea(height4)); // 0
    }
}
