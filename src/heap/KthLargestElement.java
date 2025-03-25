package heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author rj
 * @className FindKthLargest
 * @description leetcode 215. 数组中的第K个最大元素
 * @date 2025/3/25 10:37
 */
public class KthLargestElement {
    public int findKthLargestQuick(int[] nums, int k) {
        // 第 k 大的元素在升序排序中的索引
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    public int findKthLargestHeap(int[] nums, int k) {
        // 创建一个大小为 k 的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 遍历数组中的每个元素
        for (int num : nums) {
            if (minHeap.size() < k) {
                // 如果堆的大小小于 k，直接插入
                minHeap.offer(num);
            } else {
                // 如果堆的大小已经达到 k，比较当前元素与堆顶元素
                if (num > minHeap.peek()) {
                    // 替换堆顶元素
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }

        // 堆顶元素即为第 k 大的元素
        return minHeap.peek();
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) {
            return nums[left];
        }

        // 随机选择枢轴
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);

        // 分区操作
        pivotIndex = partition(nums, left, right, pivotIndex);

        // 检查枢轴是否为目标索引
        if (pivotIndex == targetIndex) {
            return nums[pivotIndex];
        } else if (pivotIndex < targetIndex) {
            // 目标在右侧部分
            return quickSelect(nums, pivotIndex + 1, right, targetIndex);
        } else {
            // 目标在左侧部分
            return quickSelect(nums, left, pivotIndex - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        // 将枢轴移到末尾
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        // 分区操作
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        // 将枢轴移回正确位置
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();

        // 示例 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(solution.findKthLargestQuick(nums1, k1)); // 输出: 5

        // 示例 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(solution.findKthLargestQuick(nums2, k2)); // 输出: 4
    }
}
