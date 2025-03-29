package linkedlist;

/**
 * @author rj
 * @className ListNode
 * @description 链表节点类实现
 * @date 2025/3/29 11:41
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    /**
     * 根据数组构建链表
     */
    public static ListNode build(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 打印链表
     */
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + '}';
    }
}
