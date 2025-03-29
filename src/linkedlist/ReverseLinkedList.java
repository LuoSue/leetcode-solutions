package linkedlist;

/**
 * @author rj
 * @className ReverseLinkedList
 * @description leetcode 206. 反转链表
 * @date 2025/3/29 20:02
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }


        ListNode pre = null;    // 前驱节点初始化为null
        ListNode cur = head;     // 当前节点初始化为头节点

        while(cur != null){      // 遍历链表直到末尾
            ListNode nextNode = cur.next;  // 临时保存下一个节点
            cur.next = pre;     // 反转指针方向
            pre = cur;           // pre指针前移
            cur = nextNode;      // cur指针前移
        }

        return pre;  // 循环结束时pre指向原链表的尾节点，即新链表的头节点
    }

    public ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode head1 = ListNode.build(new int[]{1,2,3,4,5});
        System.out.println("测试用例1: " + ListNode.toString(solution.reverseList(head1)));

        ListNode head2 = ListNode.build(new int[]{1,2});
        System.out.println("测试用例2: " + ListNode.toString(solution.reverseList(head2)));

        ListNode head3 = ListNode.build(new int[]{});
        System.out.println("测试用例3: " + ListNode.toString(solution.reverseList(head3)));
    }
}
