package array;

import java.util.*;

/**
 * @author rj
 * @className GroupAnagrams
 * @description leetcode 49. 字母异位词分组
 * @date 2025/3/27 10:57
 */
public class GroupAnagrams {

    // 方法1：排序字符串作为key
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // 更简洁的写法，避免重复检查key是否存在
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // 方法2：使用字符计数作为key（更高效，适合长字符串）
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // 测试用例1：普通情况
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("测试1结果: " + solution.groupAnagrams(strs1));
        // 期望输出: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

        // 测试用例2：空数组
        String[] strs2 = {};
        System.out.println("测试2结果: " + solution.groupAnagrams(strs2));
        // 期望输出: []

        // 测试用例3：单个空字符串
        String[] strs3 = {""};
        System.out.println("测试3结果: " + solution.groupAnagrams(strs3));
        // 期望输出: [[""]]

        // 测试用例4：所有字符串相同
        String[] strs4 = {"a", "a", "a"};
        System.out.println("测试4结果: " + solution.groupAnagrams(strs4));
        // 期望输出: [["a", "a", "a"]]

        // 测试方法2
        System.out.println("\n方法2测试:");
        System.out.println("测试1结果: " + solution.groupAnagrams2(strs1));
    }
}
