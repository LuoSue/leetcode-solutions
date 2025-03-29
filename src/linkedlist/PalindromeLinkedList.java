package linkedlist;

/**
 * @author rj
 * @className PalindromeLinkedList
 * @description leetcode 234. 回文链表
 * @date 2025/3/29 20:17
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1.使用快慢指针找到中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.反转链表后半部分
        ListNode prev = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // 3.比较前半部分和反转后的后半部分
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // 测试用例1: 空链表
        ListNode case1 = null;
        System.out.println("测试用例1 (空链表): " + solution.isPalindrome(case1));
        System.out.println("链表内容: null");
        System.out.println("预期结果: true\n");

        // 测试用例2: 单节点链表
        ListNode case2 = ListNode.build(new int[]{1});
        System.out.println("测试用例2 (单节点): " + solution.isPalindrome(case2));
        System.out.println("链表内容: " + ListNode.toString(case2));
        System.out.println("预期结果: true\n");

        // 测试用例3: 偶数长度回文链表
        ListNode case3 = ListNode.build(new int[]{1, 2, 2, 1});
        System.out.println("测试用例3 (偶数回文): " + solution.isPalindrome(case3));
        System.out.println("链表内容: " + ListNode.toString(case3));
        System.out.println("预期结果: true\n");

        // 测试用例4: 奇数长度回文链表
        ListNode case4 = ListNode.build(new int[]{1, 2, 3, 2, 1});
        System.out.println("测试用例4 (奇数回文): " + solution.isPalindrome(case4));
        System.out.println("链表内容: " + ListNode.toString(case4));
        System.out.println("预期结果: true\n");

        // 测试用例5: 非回文链表
        ListNode case5 = ListNode.build(new int[]{1, 2, 3, 4});
        System.out.println("测试用例5 (非回文): " + solution.isPalindrome(case5));
        System.out.println("链表内容: " + ListNode.toString(case5));
        System.out.println("预期结果: false\n");

        // 测试用例6: 长回文链表
        ListNode case6 = ListNode.build(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1});
        System.out.println("测试用例6 (长回文): " + solution.isPalindrome(case6));
        System.out.println("链表内容: " + ListNode.toString(case6));
        System.out.println("预期结果: true\n");

        // 测试用例7: 几乎回文但有一个不同
        ListNode case7 = ListNode.build(new int[]{1, 2, 3, 4, 3, 2, 1});
        System.out.println("测试用例7 (几乎回文): " + solution.isPalindrome(case7));
        System.out.println("链表内容: " + ListNode.toString(case7));
        System.out.println("预期结果: false\n");

        // 测试用例8: 两个不同节点
        ListNode case8 = ListNode.build(new int[]{1, 2});
        System.out.println("测试用例8 (两节点非回文): " + solution.isPalindrome(case8));
        System.out.println("链表内容: " + ListNode.toString(case8));
        System.out.println("预期结果: false\n");

        // 测试用例9: 两个相同节点
        ListNode case9 = ListNode.build(new int[]{1, 1});
        System.out.println("测试用例9 (两节点回文): " + solution.isPalindrome(case9));
        System.out.println("链表内容: " + ListNode.toString(case9));
        System.out.println("预期结果: true\n");

        // 测试用例10: 所有节点相同
        ListNode case10 = ListNode.build(new int[]{5, 5, 5, 5, 5});
        System.out.println("测试用例10 (全相同): " + solution.isPalindrome(case10));
        System.out.println("链表内容: " + ListNode.toString(case10));
        System.out.println("预期结果: true");
    }
}
