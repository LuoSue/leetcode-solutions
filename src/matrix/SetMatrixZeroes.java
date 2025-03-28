package matrix;

import java.util.Arrays;

/**
 * @author rj
 * @className SetMatrixZeroes
 * @description leetcode 73. 矩阵置零
 * @date 2025/3/28 10:27
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // 检查第一行是否有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 使用第一行和第一列来标记其他行列是否有0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据标记，将对应的行和列置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 处理第一列
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();

        // 示例1
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix1);
        System.out.println("示例1结果:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        // 预期输出:
        // [1, 0, 1]
        // [0, 0, 0]
        // [1, 0, 1]

        // 示例2
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix2);
        System.out.println("\n示例2结果:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        // 预期输出:
        // [0, 0, 0, 0]
        // [0, 4, 5, 0]
        // [0, 3, 1, 0]

        // 示例3
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 0}
        };
        solution.setZeroes(matrix3);
        System.out.println("\n示例3结果:");
        for (int[] row : matrix3) {
            System.out.println(Arrays.toString(row));
        }
        // 预期输出:
        // [1, 0, 3, 0]
        // [0, 0, 0, 0]
        // [0, 0, 0, 0]
    }
}
