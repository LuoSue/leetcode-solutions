package linkedlist;

import java.util.PriorityQueue;

/**
 * @author rj
 * @className MergekSortedLists
 * @description leetcode 23. 合并 K 个升序链表
 * @date 2025/3/30 10:46
 */
public class MergekSortedLists {

    /**
     * 使用最小堆合并K个有序链表
     * @param lists 链表数组，每个链表都已按升序排列
     * @return 合并后的有序链表头节点
     */
    public ListNode mergeKListsUsingMinHeap(ListNode[] lists) {
        // 处理边界情况：输入为空或长度为0
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建最小堆，按照节点值从小到大排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (node1, node2) -> node1.val - node2.val
        );

        // 将所有链表的头节点加入最小堆
        for (ListNode headNode : lists) {
            if (headNode != null) {
                minHeap.offer(headNode);
            }
        }

        // 创建虚拟头节点简化操作
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // 不断从堆中取出最小节点进行合并
        while (!minHeap.isEmpty()) {
            // 获取当前最小节点
            ListNode smallestNode = minHeap.poll();
            // 将最小节点连接到结果链表
            current.next = smallestNode;
            current = current.next;

            // 如果最小节点所在链表还有后续节点，将其加入堆中
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummyHead.next;
    }

    /**
     * 使用分治法合并K个有序链表
     * @param lists 链表数组，每个链表都已按升序排列
     * @return 合并后的有序链表头节点
     */
    public ListNode mergeKListsUsingDivideAndConquer(ListNode[] lists) {
        // 处理边界情况
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 调用分治合并方法
        return mergeListsByDivideAndConquer(lists, 0, lists.length - 1);
    }

    /**
     * 分治合并链表数组的递归方法
     * @param lists 链表数组
     * @param left 当前处理范围的左边界
     * @param right 当前处理范围的右边界
     * @return 合并后的链表头节点
     */
    private ListNode mergeListsByDivideAndConquer(ListNode[] lists, int left, int right) {
        // 递归终止条件：只有一个链表时直接返回
        if (left == right) {
            return lists[left];
        }

        // 计算中间位置
        int mid = left + (right - left) / 2;
        // 递归合并左半部分链表
        ListNode leftMerged = mergeListsByDivideAndConquer(lists, left, mid);
        // 递归合并右半部分链表
        ListNode rightMerged = mergeListsByDivideAndConquer(lists, mid + 1, right);
        // 合并两个已排序链表
        return mergeTwoSortedLists(leftMerged, rightMerged);
    }

    /**
     * 合并两个有序链表
     * @param list1 第一个有序链表
     * @param list2 第二个有序链表
     * @return 合并后的有序链表头节点
     */
    private ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        // 创建虚拟头节点简化操作
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // 同时遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 将剩余部分直接连接到结果链表
        current.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergekSortedLists solution = new MergekSortedLists();

        // 示例测试1：多个非空链表
        ListNode[] testCase1 = {
                ListNode.build(new int[]{1, 4, 5}),
                ListNode.build(new int[]{1, 3, 4}),
                ListNode.build(new int[]{2, 6})
        };
        System.out.println("测试1 - 最小堆法: " +
                ListNode.toString(solution.mergeKListsUsingMinHeap(testCase1)));
        System.out.println("测试1 - 分治法: " +
                ListNode.toString(solution.mergeKListsUsingDivideAndConquer(testCase1)));

        // 示例测试2：空数组
        ListNode[] testCase2 = {};
        System.out.println("测试2 - 最小堆法: " +
                ListNode.toString(solution.mergeKListsUsingMinHeap(testCase2)));
        System.out.println("测试2 - 分治法: " +
                ListNode.toString(solution.mergeKListsUsingDivideAndConquer(testCase2)));

        // 示例测试3：包含空链表的数组
        ListNode[] testCase3 = {null};
        System.out.println("测试3 - 最小堆法: " +
                ListNode.toString(solution.mergeKListsUsingMinHeap(testCase3)));
        System.out.println("测试3 - 分治法: " +
                ListNode.toString(solution.mergeKListsUsingDivideAndConquer(testCase3)));
    }
}