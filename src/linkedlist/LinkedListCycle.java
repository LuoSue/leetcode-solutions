package linkedlist;

/**
 * @author rj
 * @className LinkedListCycle
 * @description leetcode 141. 环形链表
 * @date 2025/3/29 20:28
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
    
}
