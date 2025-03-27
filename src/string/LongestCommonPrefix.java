package string;

import java.util.Arrays;

/**
 * @author rj
 * @className LongestCommonPrefix
 * @description leetcode 14. 最长公共前缀
 * @date 2025/3/26 17:38
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 以第一个字符串作为基准
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // 不断缩短prefix直到找到公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        String[] strs1 = new String[]{"flower","flow","flight"};
        System.out.println(Arrays.toString(strs1) + " ==> " + solution.longestCommonPrefix(strs1));

        String[] strs2 = new String[]{"dog","racecar","car"};
        System.out.println(Arrays.toString(strs2) + " ==> " + solution.longestCommonPrefix(strs2));
    }
}
