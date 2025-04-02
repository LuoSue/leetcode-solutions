package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rj
 * @className SwCoAW
 * @description leetcode 30. 串联所有单词的子串
 * @date 2025/4/2 10:14
 */
public class SwCoAW {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (!wordCount.containsKey(word)) {
                    currentCount.clear();
                    left = right;
                } else {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLen;
                    }
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }
}
