package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author rj
 * @className SlidingWindowMaximum
 * @description leetcode 239. 滑动窗口最大值
 * @date 2025/3/28 9:45
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int n = nums.length;
        int[] windowMax = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // 存储的是索引，保证对应的元素是递减的

        for (int i = 0; i < n; i++) {
            // 移除不在滑动窗口内的元素（从队列头部）
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 移除所有小于当前元素的索引（从队列尾部）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加当前元素的索引
            deque.offerLast(i);

            // 当窗口大小达到 k 时，记录最大值
            if (i >= k - 1) {
                windowMax[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return windowMax;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        // 测试用例
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println(java.util.Arrays.toString(result1)); // 预期输出: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println(java.util.Arrays.toString(result2)); // 预期输出: [1]

        int[] nums3 = {1, -1};
        int k3 = 1;
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.println(java.util.Arrays.toString(result3)); // 预期输出: [1, -1]

        int[] nums4 = {9, 11};
        int k4 = 2;
        int[] result4 = solution.maxSlidingWindow(nums4, k4);
        System.out.println(java.util.Arrays.toString(result4)); // 预期输出: [11]

        int[] nums5 = {4, -2};
        int k5 = 2;
        int[] result5 = solution.maxSlidingWindow(nums5, k5);
        System.out.println(java.util.Arrays.toString(result5)); // 预期输出: [4]
    }
}
