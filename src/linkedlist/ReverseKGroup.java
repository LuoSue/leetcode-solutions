package linkedlist;

/**
 * @author rj
 * @className ReverseKGroup
 * @description leetcode 25. K 个一组翻转链表
 * @date 2025/3/29 22:36
 */

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建虚拟头节点，方便操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // `prev` 指向每一组的前驱节点
        ListNode curr = head;  // `curr` 指向当前要处理的节点

        // 计算链表长度
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 重新指向头部，开始迭代
        curr = head;

        while (length >= k) {  // 只处理完整的 k 组
            ListNode last = prev.next; // 记录每组翻转前的第一个节点，翻转后它会成为最后一个
            ListNode next = last.next; // 记录要交换的第二个节点

            // 交换 k-1 次
            for (int i = 0; i < k - 1; i++) {
                last.next = next.next; // 断开 `next` 并向后移动
                next.next = prev.next; // `next` 插入到 `prev` 后
                prev.next = next;      // 更新 `prev` 指向新的头
                next = last.next;      // 继续处理下一个节点
            }

            // `prev` 移动到当前翻转部分的尾部，`last` 现在是这一组的尾部
            prev = last;
            length -= k; // 处理了一组，减少 k
        }

        return dummy.next; // 返回新的头节点
    }

    public static void main(String[] args) {
        ReverseKGroup solution = new ReverseKGroup();

        // 测试用例1: 正常情况 (k=2)
        ListNode head1 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution.reverseKGroup(head1, 2);
        System.out.println("测试用例1 (k=2): " + ListNode.toString(result1));
        System.out.println("预期结果: 2 -> 1 -> 4 -> 3 -> 5\n");

        // 测试用例2: 正常情况 (k=3)
        ListNode head2 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = solution.reverseKGroup(head2, 3);
        System.out.println("测试用例2 (k=3): " + ListNode.toString(result2));
        System.out.println("预期结果: 3 -> 2 -> 1 -> 4 -> 5\n");

        // 测试用例3: k等于链表长度
        ListNode head3 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result3 = solution.reverseKGroup(head3, 5);
        System.out.println("测试用例3 (k=5): " + ListNode.toString(result3));
        System.out.println("预期结果: 5 -> 4 -> 3 -> 2 -> 1\n");

        // 测试用例4: k=1 (不翻转)
        ListNode head4 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result4 = solution.reverseKGroup(head4, 1);
        System.out.println("测试用例4 (k=1): " + ListNode.toString(result4));
        System.out.println("预期结果: 1 -> 2 -> 3 -> 4 -> 5\n");

        // 测试用例5: 链表长度不是k的整数倍
        ListNode head5 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result5 = solution.reverseKGroup(head5, 3);
        System.out.println("测试用例5 (k=3): " + ListNode.toString(result5));
        System.out.println("预期结果: 3 -> 2 -> 1 -> 4 -> 5\n");

        // 测试用例6: 空链表
        ListNode head6 = null;
        ListNode result6 = solution.reverseKGroup(head6, 2);
        System.out.println("测试用例6 (空链表): " + ListNode.toString(result6));
        System.out.println("预期结果: null\n");

        // 测试用例7: 单个节点
        ListNode head7 = ListNode.build(new int[]{1});
        ListNode result7 = solution.reverseKGroup(head7, 2);
        System.out.println("测试用例7 (单个节点): " + ListNode.toString(result7));
        System.out.println("预期结果: 1");
    }
}
