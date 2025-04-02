package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rj
 * @className TextJustification
 * @description leetcode 68. 文本左右对齐
 * @date 2025/4/2 9:54
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // 存储最终结果的列表
        int index = 0; // 当前处理到的单词的起始索引
        int n = words.length; // 单词数组的长度

        while (index < n) {
            // 步骤1：确定当前行可以放置的单词
            int totalChars = words[index].length(); // 当前行单词的总长度（初始为第一个单词的长度）
            int last = index + 1; // 当前行最后一个单词的索引（初始为index + 1）

            // 尝试将下一个单词加入当前行，直到无法再加入而不超过maxWidth
            while (last < n) {
                // 如果加入下一个单词后的总长度（当前总长度 + 空格 + 下一个单词的长度）超过maxWidth，则停止
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length(); // 更新总长度
                last++; // 移动到下一个单词
            }

            int gaps = last - index - 1; // 当前行单词之间的间隔数（单词数 - 1）
            StringBuilder line = new StringBuilder(); // 用于构建当前行的字符串

            // 步骤2：根据当前行是否是最后一行或只有一个单词，分别处理
            if (last == n || gaps == 0) {
                // 情况1：最后一行或只有一个单词的行（左对齐，单词间一个空格，末尾填充空格）
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" "); // 单词之间加一个空格
                }
                // 在行末填充空格，直到达到maxWidth
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // 情况2：常规行（左右对齐，均匀分配空格）
                // 计算需要分配的总空格数：maxWidth - 当前行所有单词的总长度（不含空格）
                int totalSpaces = maxWidth - (totalChars - gaps); // totalChars - gaps 即为所有单词的总长度
                int baseSpaces = totalSpaces / gaps; // 每个间隔的基本空格数
                int extraSpaces = totalSpaces % gaps; // 需要额外分配的空格数（从左到右分配）

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        // 计算当前间隔的空格数：基本空格数 + 是否分配额外空格
                        int spaces = baseSpaces + (i - index < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spaces; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString()); // 将构建好的行添加到结果列表
            index = last; // 移动到下一行的起始单词
        }

        return result; // 返回最终结果
    }
}
