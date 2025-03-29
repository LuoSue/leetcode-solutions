package linkedlist;

/**
 * @author rj
 * @className LinkedListCycle2
 * @description leetcode 142. 环形链表 II
 * @date 2025/3/29 21:47
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        // 判断是否存在环
        ListNode intersectNode = getIntersectionNode(head);
        if (intersectNode == null) {
            return null;
        }

        // 从链表头和相遇点同时移动，直到它们再次相遇
        ListNode ptr1 = head;
        ListNode ptr2 = intersectNode;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // 返回环的起始节点
        return ptr1;
    }

    // 获取相遇节点，如果没有环则返回null
    private ListNode getIntersectionNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 如果相遇，则存在环
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }
}
