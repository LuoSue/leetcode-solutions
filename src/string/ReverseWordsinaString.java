package string;

/**
 * @author rj
 * @className ReverseWordsinaString
 * @description leetcode 151. 反转字符串中的单词
 * @date 2025/4/1 10:14
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        // 去除多余空格
        StringBuilder sb = trimSpaces(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去除前导空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        // 去除尾随空格
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        // 去除中间多余空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            // 找到单词的结束位置
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            // 反转单词
            reverse(sb, start, end - 1);
            // 更新 start 和 end
            start = end + 1;
            end = start;
        }
    }
}
