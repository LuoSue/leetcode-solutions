package stack;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * @author rj
 * @className ValidParentheses
 * @description leetcode 20. 有效的括号
 * @date 2025/3/24 15:12
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // 使用 Deque 作为栈
        Deque<Character> stack = new ArrayDeque<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果是左括号，压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果是右括号，检查栈是否为空以及栈顶是否匹配
                if (stack.isEmpty()) {
                    return false; // 栈为空，没有匹配的左括号
                }
                char top = stack.pop(); // 弹出栈顶元素
                if (!isMatchingPair(top, c)) {
                    return false; // 栈顶元素与当前右括号不匹配
                }
            }
        }

        // 最终检查栈是否为空
        return stack.isEmpty();
    }

    // 辅助方法：判断左右括号是否匹配
    private boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }

    // 测试用例
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        System.out.println(solution.isValid("()"));       // 输出: true
        System.out.println(solution.isValid("()[]{}"));   // 输出: true
        System.out.println(solution.isValid("(]"));       // 输出: false
        System.out.println(solution.isValid("([])"));     // 输出: true
    }
}
