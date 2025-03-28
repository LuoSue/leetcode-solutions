package matrix;

import java.util.Arrays;

/**
 * @author rj
 * @className RotateImage
 * @description leetcode 48. 旋转图像
 * @date 2025/3/28 10:32
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        // 示例1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix1);
        System.out.println("示例1结果:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        // 预期输出:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]

        // 示例2
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix2);
        System.out.println("\n示例2结果:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        // 预期输出:
        // [15, 13, 2, 5]
        // [14, 3, 4, 1]
        // [12, 6, 8, 9]
        // [16, 7, 10, 11]
    }
}