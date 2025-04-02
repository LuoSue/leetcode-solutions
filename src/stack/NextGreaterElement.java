package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className NextGreaterElement
 * @description leetcode 496. 下一个更大元素 I
 * @date 2025/4/2 14:58
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 使用 HashMap 存储每个元素的下一个更大元素
        Map<Integer, Integer> nextGreater = new HashMap<>();
        // 使用 Deque 维护单调栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 遍历 nums2，找到所有元素的下一个更大元素
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // 对于栈中剩余的元素，没有下一个更大元素，映射为 -1
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // 根据 nums1 构造答案数组
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}
