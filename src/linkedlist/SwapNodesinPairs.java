package linkedlist;

/**
 * @author rj
 * @className SwapNodesinPairs
 * @description leetcode 24. 两两交换链表中的节点
 * @date 2025/3/29 22:28
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode current = dummy;

        while(current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesinPairs solution = new SwapNodesinPairs();

        ListNode l1 = ListNode.build(new int[]{1,2,3,4});
        System.out.println(ListNode.toString(solution.swapPairs(l1)));
    }
}
