package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rj
 * @className RottingOranges
 * @description leetcode - 994. 腐烂的橘子
 * @date 2025/3/21 9:49
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; // 新鲜橘子的数量

        // 方向数组，用于遍历上下左右四个方向
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 初始化队列，将所有腐烂的橘子入队，同时统计新鲜橘子数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // 如果没有新鲜橘子，直接返回 0
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotting = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                // 遍历四个方向
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // 如果新的位置在网格内，并且是新鲜橘子
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // 让橘子腐烂
                        queue.offer(new int[]{newX, newY}); // 加入队列
                        freshCount--; // 减少新鲜橘子的数量
                        hasRotting = true;
                    }
                }
            }

            if (hasRotting) {
                minutes++;
            }
        }

        // 如果还有新鲜橘子，返回 -1，否则返回所需时间
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid1)); // 输出 4

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(solution.orangesRotting(grid2)); // 输出 -1

        int[][] grid3 = {{0,2}};
        System.out.println(solution.orangesRotting(grid3)); // 输出 0
    }
}
