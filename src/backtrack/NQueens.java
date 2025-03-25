package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className NQueens
 * @description
 * @date 2025/3/24 11:08
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 标记列、主对角线、副对角线的状态
        boolean[] cols = new boolean[n];              // 列占用情况
        boolean[] mainDiagonal = new boolean[2 * n];  // 主对角线占用情况
        boolean[] antiDiagonal = new boolean[2 * n];  // 副对角线占用情况

        backtrack(board, 0, cols, mainDiagonal, antiDiagonal, result);
        return result;
    }

    private void backtrack(char[][] board, int row, boolean[] cols, boolean[] mainDiagonal, boolean[] antiDiagonal, List<List<String>> result) {
        int n = board.length;

        // 如果所有行都放置了皇后，记录当前棋盘状态
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < n; col++) {
            // 检查列、主对角线、副对角线是否有冲突
            if (cols[col] || mainDiagonal[row - col + n] || antiDiagonal[row + col]) {
                continue;
            }

            // 放置皇后
            board[row][col] = 'Q';
            cols[col] = true;
            mainDiagonal[row - col + n] = true;
            antiDiagonal[row + col] = true;

            // 递归处理下一行
            backtrack(board, row + 1, cols, mainDiagonal, antiDiagonal, result);

            // 回溯：撤销当前放置的皇后
            board[row][col] = '.';
            cols[col] = false;
            mainDiagonal[row - col + n] = false;
            antiDiagonal[row + col] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();

        // 示例 1
        int n1 = 4;
        System.out.println(solution.solveNQueens(n1));
        // 输出: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

        // 示例 2
        int n2 = 1;
        System.out.println(solution.solveNQueens(n2));
        // 输出: [["Q"]]
    }
}
