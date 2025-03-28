package matrix;

/**
 * @author rj
 * @className Searcha2DMatrix2
 * @description leetcode 240. 搜索二维矩阵 II
 * @date 2025/3/28 10:41
 */
public class Searcha2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Searcha2DMatrix2 solution = new Searcha2DMatrix2();

        // 示例1
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println("示例1结果: " + solution.searchMatrix(matrix1, target1)); // 预期输出: true

        // 示例2
        int target2 = 20;
        System.out.println("示例2结果: " + solution.searchMatrix(matrix1, target2)); // 预期输出: false

        // 示例3
        int[][] matrix3 = {
                {1, 1}
        };
        int target3 = 2;
        System.out.println("示例3结果: " + solution.searchMatrix(matrix3, target3)); // 预期输出: false
    }
}
