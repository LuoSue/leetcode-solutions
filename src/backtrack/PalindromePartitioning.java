package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className PalindromePartitioning
 * @description leetcode 131. 分割回文串
 * @date 2025/3/24 11:01
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();
        // 预处理 isPalindrome 数组
        boolean[][] isPalindrome = new boolean[n][n];
        preprocessIsPalindrome(s, isPalindrome);

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, isPalindrome);
        return result;
    }

    private void preprocessIsPalindrome(String s, boolean[][] isPalindrome) {
        int n = s.length();
        // 单个字符一定是回文
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        // 处理长度为 2 及以上的子串
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] isPalindrome) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path)); // 深拷贝当前路径
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                path.add(s.substring(start, end + 1)); // 加入当前回文子串
                backtrack(s, end + 1, path, result, isPalindrome); // 递归处理剩余部分
                path.remove(path.size() - 1); // 回溯
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();

        // 示例 1
        String s1 = "aab";
        System.out.println(solution.partition(s1)); // 输出: [["a","a","b"],["aa","b"]]

        // 示例 2
        String s2 = "a";
        System.out.println(solution.partition(s2)); // 输出: [["a"]]
    }
}
