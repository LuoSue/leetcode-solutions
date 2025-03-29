package linkedlist;

/**
 * @author rj
 * @className IntersectionofTwoLinkedLists
 * @description leetcode 160. 相交链表
 * @date 2025/3/29 11:45
 */
public class IntersectionofTwoLinkedLists {
    /**
     * 查找两个链表的交点
     * 算法思想：让两个指针分别遍历两个链表，当到达末尾时切换到另一个链表的头部继续遍历。
     * 如果链表相交，指针最终会在交点相遇；如果不相交，最终都会到达null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界条件检查
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // 当两个指针不相等时继续循环
        while (pointerA != pointerB) {
            // 指针A到达末尾后转到链表B头部
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // 指针B到达末尾后转到链表A头部
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // 返回交点（如果不相交则返回null）
        return pointerA;
    }

    public static void main(String[] args) {
        IntersectionofTwoLinkedLists solution = new IntersectionofTwoLinkedLists();

        // 测试用例1: 不相交的链表
        ListNode headA1 = ListNode.build(new int[]{1, 2, 3});
        ListNode headB1 = ListNode.build(new int[]{4, 5});
        System.out.println("测试用例1: " + solution.getIntersectionNode(headA1, headB1)); // 应输出null

        // 测试用例2: 相交的链表
        ListNode common = ListNode.build(new int[]{8, 9, 10});
        ListNode headA2 = new ListNode(1, new ListNode(2, new ListNode(3, common)));
        ListNode headB2 = new ListNode(4, new ListNode(5, common));
        System.out.println("测试用例2: " + solution.getIntersectionNode(headA2, headB2).val); // 应输出8

        // 测试用例3: 一个链表为空
        ListNode headA3 = ListNode.build(new int[]{1, 2, 3});
        ListNode headB3 = null;
        System.out.println("测试用例3: " + solution.getIntersectionNode(headA3, headB3)); // 应输出null
    }
}
