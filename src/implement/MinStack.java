package implement;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rj
 * @className MinStack
 * @description leetcode 155. 最小栈
 * @date 2025/4/2 9:46
 */
public class MinStack {
    private Deque<Integer> stack;        // 主栈存储所有值
    private Deque<Integer> minStack;     // 辅助栈存储最小值

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        // 如果 minStack 为空，或者新值小于等于当前最小值，就压入 minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        // 如果弹出的值等于当前最小值，也需要从 minStack 弹出
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }
}
