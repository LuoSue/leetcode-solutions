package linkedlist;

/**
 * @author rj
 * @className SortList
 * @description leetcode 148. 排序链表
 * @date 2025/3/30 10:35
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next, l, r;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        r = mergeSort(slow.next);
        slow.next = null;
        l = mergeSort(head);
        return mergeList(head, l, r);
    }

    public ListNode mergeList(ListNode head, ListNode l, ListNode r) {
        ListNode p = new ListNode(0);
        ListNode node = p;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return node.next;
    }

    public static void main(String[] args) {
        // 示例1: 随机顺序
        int[] nums1 = {4, 2, 1, 3};
        ListNode head1 = ListNode.build(nums1);
        System.out.println("排序前: " + ListNode.toString(head1));
        ListNode sorted1 = new SortList().sortList(head1);
        System.out.println("排序后: " + ListNode.toString(sorted1));

        // 示例2: 逆序
        int[] nums2 = {5, 4, 3, 2, 1};
        ListNode head2 = ListNode.build(nums2);
        System.out.println("\n排序前: " + ListNode.toString(head2));
        ListNode sorted2 = new SortList().sortList(head2);
        System.out.println("排序后: " + ListNode.toString(sorted2));

        // 示例3: 已排序
        int[] nums3 = {1, 2, 3, 4, 5};
        ListNode head3 = ListNode.build(nums3);
        System.out.println("\n排序前: " + ListNode.toString(head3));
        ListNode sorted3 = new SortList().sortList(head3);
        System.out.println("排序后: " + ListNode.toString(sorted3));

        // 示例4: 空链表
        ListNode head4 = null;
        System.out.println("\n排序前: " + ListNode.toString(head4));
        ListNode sorted4 = new SortList().sortList(head4);
        System.out.println("排序后: " + ListNode.toString(sorted4));

        // 示例5: 单个元素
        int[] nums5 = {1};
        ListNode head5 = ListNode.build(nums5);
        System.out.println("\n排序前: " + ListNode.toString(head5));
        ListNode sorted5 = new SortList().sortList(head5);
        System.out.println("排序后: " + ListNode.toString(sorted5));
    }
}
