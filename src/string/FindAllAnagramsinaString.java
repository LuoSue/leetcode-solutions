package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rj
 * @className FindAllAnagramsinaString
 * @description leetcode 438. 找到字符串中所有字母异位词
 * @date 2025/3/27 14:57
 */
public class FindAllAnagramsinaString {
    /**
     * 滑动窗口法：找到所有字母异位词的起始索引。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] targetCount = new int[26];  // 目标字符计数
        int[] windowCount = new int[26];  // 当前窗口字符计数

        // 初始化目标字符计数
        for (int i = 0; i < p.length(); i++) {
            targetCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        // 比较第一个窗口
        if (isAnagram(targetCount, windowCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 添加新字符到窗口
            windowCount[s.charAt(i) - 'a']++;
            // 移除旧字符
            windowCount[s.charAt(i - p.length()) - 'a']--;

            // 检查是否是字母异位词
            if (isAnagram(targetCount, windowCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    // 判断两个字符计数数组是否相等
    private boolean isAnagram(int[] targetCount, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (targetCount[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] targetCount = new int[26];
        int[] windowCount = new int[26];
        int matchCount = 0;

        // 初始化目标字符计数
        for (char c : p.toCharArray()) {
            targetCount[c - 'a']++;
        }

        // 初始化窗口
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (targetCount[c - 'a'] > 0) {
                windowCount[c - 'a']++;
                if (windowCount[c - 'a'] <= targetCount[c - 'a']) {
                    matchCount++;
                }
            }
        }

        if (matchCount == p.length()) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 移除左边字符
            char leftChar = s.charAt(i - p.length());
            if (targetCount[leftChar - 'a'] > 0) {
                if (windowCount[leftChar - 'a'] <= targetCount[leftChar - 'a']) {
                    matchCount--;
                }
                windowCount[leftChar - 'a']--;
            }

            // 添加右边字符
            char rightChar = s.charAt(i);
            if (targetCount[rightChar - 'a'] > 0) {
                windowCount[rightChar - 'a']++;
                if (windowCount[rightChar - 'a'] <= targetCount[rightChar - 'a']) {
                    matchCount++;
                }
            }

            // 检查是否匹配
            if (matchCount == p.length()) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public List<Integer> findAnagramsWithMap(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int matchCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    matchCount++;
                }
            }

            if (right >= p.length() - 1) {
                if (matchCount == targetMap.size()) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(targetMap.get(leftChar))) {
                        matchCount--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString finder = new FindAllAnagramsinaString();

        // 测试用例
        System.out.println(finder.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(finder.findAnagrams("abab", "ab"));       // [0, 1, 2]
        System.out.println(finder.findAnagrams("aaaa", "bb"));       // []
        System.out.println(finder.findAnagrams("", "a"));            // []
    }
}
