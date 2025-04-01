package string;

/**
 * @author rj
 * @className LengthofLastWord
 * @description leetcode 58. 最后一个单词的长度
 * @date 2025/4/1 10:10
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        // 去除末尾的空格
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        // 从后向前遍历，统计最后一个单词的长度
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
