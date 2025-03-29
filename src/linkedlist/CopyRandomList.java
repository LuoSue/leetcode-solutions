package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className CopyRandomList
 * @description leetcode 138. 随机链表的复制
 * @date 2025/3/29 22:42
 */

public class CopyRandomList {

    // 定义 Node 类
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        // 用于打印链表的方法
        public static String toString(Node head) {
            StringBuilder sb = new StringBuilder();
            Map<Node, Integer> nodeToIndex = new HashMap<>();

            // 首先为每个节点分配索引
            int index = 0;
            Node current = head;
            while (current != null) {
                nodeToIndex.put(current, index++);
                current = current.next;
            }

            // 构建输出字符串
            current = head;
            while (current != null) {
                sb.append("[").append(current.val);
                if (current.random != null) {
                    sb.append(",").append(nodeToIndex.get(current.random));
                } else {
                    sb.append(",null");
                }
                sb.append("]");
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 1. 在原链表中插入复制节点
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // 2. 复制random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. 拆分链表
        Node dummy = new Node(0);
        Node copyCur = dummy;
        cur = head;
        while (cur != null) {
            copyCur.next = cur.next;
            copyCur = copyCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        CopyRandomList solution = new CopyRandomList();

        // 测试用例1: 简单链表
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        System.out.println("原始链表: " + Node.toString(node1));
        Node copy1 = solution.copyRandomList(node1);
        System.out.println("复制链表: " + Node.toString(copy1));
        System.out.println("原始链表地址: " + System.identityHashCode(node1));
        System.out.println("复制链表地址: " + System.identityHashCode(copy1));
        System.out.println("----------------------");

        // 测试用例2: 随机指针为null的情况
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.next = node5;
        node4.random = null;
        node5.random = node4;

        System.out.println("原始链表: " + Node.toString(node4));
        Node copy2 = solution.copyRandomList(node4);
        System.out.println("复制链表: " + Node.toString(copy2));
        System.out.println("----------------------");

        // 测试用例3: 单个节点
        Node node6 = new Node(6);
        node6.random = node6;

        System.out.println("原始链表: " + Node.toString(node6));
        Node copy3 = solution.copyRandomList(node6);
        System.out.println("复制链表: " + Node.toString(copy3));
        System.out.println("----------------------");

        // 测试用例4: 空链表
        Node node7 = null;

        System.out.println("原始链表: " + Node.toString(node7));
        Node copy4 = solution.copyRandomList(node7);
        System.out.println("复制链表: " + Node.toString(copy4));
    }
}
