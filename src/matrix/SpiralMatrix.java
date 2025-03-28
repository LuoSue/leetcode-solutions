package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className SpiralMatrix
 * @description leetcode 54. 螺旋矩阵
 * @date 2025/3/28 10:32
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        while (left <= right && top <= bottom) {
            // 从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 从右到左遍历下边界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 从下到上遍历左边界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        // 示例1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result1 = solution.spiralOrder(matrix1);
        System.out.println("示例1结果: " + result1); // 预期输出: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // 示例2
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> result2 = solution.spiralOrder(matrix2);
        System.out.println("示例2结果: " + result2); // 预期输出: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        // 示例3
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        List<Integer> result3 = solution.spiralOrder(matrix3);
        System.out.println("示例3结果: " + result3); // 预期输出: [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]
    }
}