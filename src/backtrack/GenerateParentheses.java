package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className GenerateParentheses
 * @description leetcode 22. 括号生成
 * @date 2025/3/24 10:44
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 如果当前字符串长度达到最大值，加入结果
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 尝试添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 尝试添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        int n = 3; // 示例输入
        List<String> combinations = generator.generateParenthesis(n);
        System.out.println(combinations); // 输出结果
    }
}
