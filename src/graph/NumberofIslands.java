package graph;

/**
 * @author rj
 * @className NumberofIslands
 * @description leetcode 200. 岛屿数量
 * @date 2025/3/21 10:15
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    public static void main(String[] args) {
        NumberofIslands solution = new NumberofIslands();

        // 测试用例1：基本示例
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Test Case 1: " + solution.numIslands(grid1)); // 应输出 1

        // 测试用例2：多个岛屿
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Test Case 2: " + solution.numIslands(grid2)); // 应输出 3

        // 测试用例3：没有岛屿
        char[][] grid3 = {
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Test Case 3: " + solution.numIslands(grid3)); // 应输出 0

        // 测试用例4：全都是岛屿
        char[][] grid4 = {
                {'1','1','1'},
                {'1','1','1'},
                {'1','1','1'}
        };
        System.out.println("Test Case 4: " + solution.numIslands(grid4)); // 应输出 1

        // 测试用例5：单个元素
        char[][] grid5 = {{'1'}};
        System.out.println("Test Case 5: " + solution.numIslands(grid5)); // 应输出 1

        // 测试用例6：空输入
        char[][] grid6 = {{}};
        System.out.println("Test Case 6: " + solution.numIslands(grid6)); // 应输出 0

        // 测试用例7：一行的情况
        char[][] grid7 = {{'0','1','0','1','0'}};
        System.out.println("Test Case 7: " + solution.numIslands(grid7)); // 应输出 2
    }
}
