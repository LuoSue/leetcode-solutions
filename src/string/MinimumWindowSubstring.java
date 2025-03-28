package string;

/**
 * @author rj
 * @className MinimumWindowSubstring
 * @description leetcode 76. 最小覆盖子串
 * @date 2025/3/28 9:52
 */
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // 统计 t 中字符的频率
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length(); // 需要匹配的字符总数

        // 滑动窗口
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符在 t 中存在，减少其频率
            if (targetFreq.containsKey(currentChar)) {
                if (targetFreq.get(currentChar) > 0) {
                    count--;
                }
                targetFreq.put(currentChar, targetFreq.get(currentChar) - 1);
            }

            // 当窗口包含所有 t 的字符时，尝试收缩窗口
            while (count == 0) {
                // 更新最小窗口
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                // 如果左边字符在 t 中，增加其频率
                if (targetFreq.containsKey(leftChar)) {
                    targetFreq.put(leftChar, targetFreq.get(leftChar) + 1);
                    if (targetFreq.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        // 测试用例
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // 输出: "BANC"
        System.out.println(solution.minWindow("a", "a")); // 输出: "a"
        System.out.println(solution.minWindow("a", "aa")); // 输出: ""
    }
}
