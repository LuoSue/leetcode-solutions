package heap;

import java.util.*;

/**
 * @author rj
 * @className TopKFrequent
 * @description leetcode 347. 前 K 个高频元素
 * @date 2025/3/25 10:54
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: 统计每个数字的频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: 使用最小堆维护频率最高的 k 个元素
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除堆顶（频率最小的元素）
            }
        }

        // Step 3: 提取结果
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        // 示例 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums1, k1))); // 输出: [1, 2]

        // 示例 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums2, k2))); // 输出: [1]
    }
}
