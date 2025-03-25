package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className PascalTriangle
 * @description leetcode 118. 杨辉三角
 * @date 2025/3/25 17:00
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();  // 存储 Pascal's 三角形
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();  // 创建当前行
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);  // 每一行的第一个和最后一个元素为 1
                } else {
                    // 计算当前行中间的元素
                    int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(value);
                }
            }
            triangle.add(row);  // 将当前行添加到 Pascal's 三角形中
        }
        return triangle;
    }

    /**
     * 主函数：测试杨辉三角生成方法
     */
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();

        // 测试用例 1：最小输入（numRows = 1）
        System.out.println("Test Case 1 (numRows = 1):");
        printTriangle(solution.generate(1));

        // 测试用例 2：小规模输入（numRows = 5）
        System.out.println("\nTest Case 2 (numRows = 5):");
        printTriangle(solution.generate(5));

        // 测试用例 3：中等规模输入（numRows = 10）
        System.out.println("\nTest Case 3 (numRows = 10):");
        printTriangle(solution.generate(10));

        // 测试用例 4：大规模输入（numRows = 15）
        System.out.println("\nTest Case 4 (numRows = 15):");
        printTriangle(solution.generate(15));
    }

    /**
     * 辅助方法：格式化打印杨辉三角
     */
    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
