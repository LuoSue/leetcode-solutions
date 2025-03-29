package linkedlist;

/**
 * @author rj
 * @className RemoveNthNodeFromEndofList
 * @description leetcode 19. 删除链表的倒数第 N 个结点
 * @date 2025/3/29 22:22
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
