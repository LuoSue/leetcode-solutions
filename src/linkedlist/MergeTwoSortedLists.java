package linkedlist;

/**
 * @author rj
 * @className MergeTwoSortedLists
 * @description leetcode 21. 合并两个有序链表
 * @date 2025/3/29 21:54
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0,null);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list2 == null ? list1 : list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        ListNode l1 = ListNode.build(new int[]{1,2,4});
        ListNode l2 = ListNode.build(new int[]{1,3,4});
        System.out.println(ListNode.toString(solution.mergeTwoLists(l1,l2)));
    }
}
