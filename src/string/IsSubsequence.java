package string;

import java.util.*;

/**
 * @author rj
 * @className IsSubsequence
 * @description leetcode 392. 判断子序列
 * @date 2025/4/2 10:12
 */
public class IsSubsequence {
    Map<Character, List<Integer>> charIndices;

    public IsSubsequence() {
        charIndices = new HashMap<>();
    }

    public boolean isSubsequence(String s, String t) {
        // Preprocess T if not already done
        if (charIndices.isEmpty()) {
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (!charIndices.containsKey(c)) {
                    charIndices.put(c, new ArrayList<>());
                }
                charIndices.get(c).add(i);
            }
        }

        int prevPos = -1;
        for (char c : s.toCharArray()) {
            if (!charIndices.containsKey(c)) {
                return false;
            }
            List<Integer> indices = charIndices.get(c);
            // Binary search for the smallest index > prevPos
            int pos = Collections.binarySearch(indices, prevPos + 1);
            if (pos < 0) {
                pos = -pos - 1;
            }
            if (pos == indices.size()) {
                return false;
            }
            prevPos = indices.get(pos);
        }
        return true;
    }
}
