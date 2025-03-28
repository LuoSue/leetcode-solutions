package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rj
 * @className MergeIntervals
 * @description leetcode 56. 合并区间
 * @date 2025/3/28 10:05
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 如果输入为空，直接返回空数组
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // 按照区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // 如果结果列表为空，或者当前区间的起始位置大于结果列表最后一个区间的结束位置
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则，合并当前区间到结果列表的最后一个区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        // 测试用例
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println(Arrays.deepToString(result1)); // 预期输出: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println(Arrays.deepToString(result2)); // 预期输出: [[1, 5]]

        int[][] intervals3 = {{1, 4}, {0, 4}};
        int[][] result3 = solution.merge(intervals3);
        System.out.println(Arrays.deepToString(result3)); // 预期输出: [[0, 4]]

        int[][] intervals4 = {{1, 4}, {2, 3}};
        int[][] result4 = solution.merge(intervals4);
        System.out.println(Arrays.deepToString(result4)); // 预期输出: [[1, 4]]
    }
}