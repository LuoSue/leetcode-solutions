package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rj
 * @className DecodeString
 * @description leetcode 394. 字符串解码
 * @date 2025/3/25 9:50
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<String> stringDeque = new ArrayDeque<>();
        Deque<Integer> numDeque = new ArrayDeque<>();

        int currentNum = 0;
        StringBuilder currentStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0'); // 修复数字处理
            } else if (ch == '[') {
                stringDeque.push(currentStr.toString()); // 使用 push 代替 offer
                numDeque.push(currentNum);              // 使用 push 代替 offer
                currentStr = new StringBuilder();
                currentNum = 0;
            } else if (ch == ']') {
                if (numDeque.isEmpty() || stringDeque.isEmpty()) { // 检查栈是否为空
                    throw new IllegalArgumentException("Invalid input format");
                }
                int num = numDeque.pop();
                String prevStr = stringDeque.pop();
                currentStr = new StringBuilder(prevStr + currentStr.toString().repeat(num));
            } else {
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        String s1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(s1)); // 输出 "aaabcbc"

        String s2 = "3[a2[c]]";
        System.out.println(solution.decodeString(s2)); // 输出 "accaccacc"

        String s3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s3)); // 输出 "abcabccdcdcdef"

        String s4 = "10[a]";
        System.out.println(solution.decodeString(s4)); // 输出 "aaaaaaaaaa"

        String s5 = "";
        System.out.println(solution.decodeString(s5)); // 输出 ""
    }
}
