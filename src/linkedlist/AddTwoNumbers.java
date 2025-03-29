package linkedlist;

/**
 * @author rj
 * @className AddTwoNumbers
 * @description leetcode 2. 两数相加
 * @date 2025/3/29 22:04
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 边界检查（题目保证非空，但实际工程中建议添加）
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0); // 虚拟头节点简化操作
        ListNode current = dummy;
        int carry = 0; // 进位值

        // 遍历两个链表，直到都到达末尾且无进位
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前节点的值，如果节点为空则视为0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // 计算总和和进位
            int totalSum = val1 + val2 + carry;
            carry = totalSum / 10;

            // 创建新节点并前进current指针
            current.next = new ListNode(totalSum % 10);
            current = current.next;

            // 前进链表指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // 跳过虚拟头节点
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // 测试用例1: 标准案例 (342 + 465 = 807)
        ListNode l1 = ListNode.build(new int[]{2, 4, 3});
        ListNode l2 = ListNode.build(new int[]{5, 6, 4});
        testCase(solution, l1, l2, "7 -> 0 -> 8");

        // 测试用例2: 长度不等的链表 (12 + 345 = 357)
        l1 = ListNode.build(new int[]{2, 1});
        l2 = ListNode.build(new int[]{5, 4, 3});
        testCase(solution, l1, l2, "7 -> 5 -> 3");

        // 测试用例3: 有进位的情况 (99 + 1 = 100)
        l1 = ListNode.build(new int[]{9, 9});
        l2 = ListNode.build(new int[]{1});
        testCase(solution, l1, l2, "0 -> 0 -> 1");

        // 测试用例4: 一个链表为空 (0 + 123 = 123)
        l1 = ListNode.build(new int[]{});
        l2 = ListNode.build(new int[]{3, 2, 1});
        testCase(solution, l1, l2, "3 -> 2 -> 1");

        // 测试用例5: 两个链表都为空 (0 + 0 = 0)
        l1 = ListNode.build(new int[]{});
        l2 = ListNode.build(new int[]{});
        testCase(solution, l1, l2, "0");
    }

    private static void testCase(AddTwoNumbers solution, ListNode l1, ListNode l2, String expected) {
        System.out.println("测试用例:");
        System.out.println("l1: " + ListNode.toString(l1));
        System.out.println("l2: " + ListNode.toString(l2));

        ListNode result = solution.addTwoNumbers(l1, l2);
        String resultStr = ListNode.toString(result);

        System.out.println("结果: " + resultStr);
        System.out.println("预期: " + expected);
        System.out.println("测试" + (resultStr.equals(expected) ? "通过" : "失败"));
        System.out.println("----------------------");
    }
}
