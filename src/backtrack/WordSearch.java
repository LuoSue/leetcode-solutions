package backtrack;

/**
 * @author rj
 * @className WordSearch
 * @description leetcode 79. 单词搜索
 * @date 2025/3/24 10:50
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // 遍历网格中的每个单元格，作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true; // 找到匹配的单词
                }
            }
        }

        return false; // 没有找到匹配的单词
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 边界条件：超出网格范围，或者当前字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 如果匹配到最后一个字符，说明找到了单词
        if (index == word.length() - 1) {
            return true;
        }

        // 标记当前单元格已访问
        char temp = board[i][j];
        board[i][j] = '#'; // 使用特殊字符标记为已访问

        // 向四个方向扩展搜索
        boolean found = dfs(board, word, i + 1, j, index + 1) || // 下
                dfs(board, word, i - 1, j, index + 1) || // 上
                dfs(board, word, i, j + 1, index + 1) || // 右
                dfs(board, word, i, j - 1, index + 1);   // 左

        // 回溯：恢复当前单元格的值
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        // 示例 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println(solution.exist(board1, word1)); // 输出: true

        // 示例 2
        String word2 = "SEE";
        System.out.println(solution.exist(board1, word2)); // 输出: true

        // 示例 3
        String word3 = "ABCB";
        System.out.println(solution.exist(board1, word3)); // 输出: false
    }
}