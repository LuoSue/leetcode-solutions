package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rj
 * @className PartitionLabels
 * @description leetcode 763. 划分字母区间
 * @date 2025/3/26 9:58
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastPosition = new int[26];
        char[] chars = s.toCharArray(); // 转为字符数组，减少 charAt() 的调用
        for (int i = 0; i < chars.length; i++) {
            lastPosition[chars[i] - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            int currentLastPos = lastPosition[currentChar - 'a']; // 缓存最后位置
            if (currentLastPos > end) {
                end = currentLastPos;
            }

            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();

        // 测试用例 1
        String s1 = "ababcbacadefegdehijhklij";
        System.out.println(solution.partitionLabels(s1)); // 输出: [9, 7, 8]

        // 测试用例 2
        String s2 = "eccbbbbdec";
        System.out.println(solution.partitionLabels(s2)); // 输出: [10]

        // 测试用例 3
        String s3 = "abcdef";
        System.out.println(solution.partitionLabels(s3)); // 输出: [1, 1, 1, 1, 1, 1]
    }
}
