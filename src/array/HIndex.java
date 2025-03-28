package array;

/**
 * @author rj
 * @className HIndex
 * @description leetcode 274. H 指数
 * H 指数是指一个科学家有 h 篇论文被引用至少 h 次，且其他 N - h 篇论文被引用不超过 h 次。
 * 本算法通过计数排序的思想，先统计每个引用次数的论文数量，然后从高到低累加，找到最大的 h。
 * @date 2025/3/28 10:56
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        // counts[i] 表示被引用 i 次的论文数量
        int[] counts = new int[n + 1];

        // 统计引用次数，超过 n 的都算作 n
        for (int citation : citations) {
            if (citation >= n) {
                counts[n]++;
            } else {
                counts[citation]++;
            }
        }

        // 从后向前累加，找到最大的 h
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0; // 这里实际上不会执行到，因为至少会返回0
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();

        int[] citations1 = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution.hIndex(citations1)); // 预期输出: 3

        int[] citations2 = new int[]{0, 0, 0};
        System.out.println(solution.hIndex(citations2)); // 预期输出: 0

        int[] citations3 = new int[]{100};
        System.out.println(solution.hIndex(citations3)); // 预期输出: 1

        int[] citations4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution.hIndex(citations4)); // 预期输出: 5
    }
}