package string;

import java.util.*;

/**
 * @author rj
 * @className LongestSubstringWithoutRepeatingCharacters
 * @description leetcode 3. 无重复字符的最长子串
 * @date 2025/3/27 14:52
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 滑动窗口法：计算无重复字符的最长子串长度。
     * 时间复杂度：O(n)，空间复杂度：O(min(m, n))，其中 m 是字符集大小
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0; // 处理空字符串或null输入
        }

        Set<Character> windowChars = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 如果当前字符已在窗口中，移动左指针直到无重复
            while (windowChars.contains(currentChar)) {
                windowChars.remove(s.charAt(left));
                left++;
            }
            // 将当前字符加入窗口
            windowChars.add(currentChar);
            // 更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                // 直接跳转到重复字符的下一个位置
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringArray(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] charIndex = new int[128]; // 假设字符是 ASCII
        Arrays.fill(charIndex, -1);
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndex[currentChar] >= left) {
                left = charIndex[currentChar] + 1;
            }
            charIndex[currentChar] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();

        // 测试用例
        System.out.println(solver.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solver.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(solver.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(solver.lengthOfLongestSubstring(""));         // 0
    }
}
