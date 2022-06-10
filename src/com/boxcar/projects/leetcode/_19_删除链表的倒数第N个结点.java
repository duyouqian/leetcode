package com.boxcar.projects.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class _19_删除链表的倒数第N个结点 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (null != tmp) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int len = list.size();
        ListNode delNode = list.get(len - n);
        ListNode preNode = delNode == head ? null : list.get(len - n - 1);
        ListNode nexNode = 1 == n ? null : list.get(len - n + 1);
        tmp = head;
        if (null == preNode) {
            tmp = tmp.next;
        } else if (null == nexNode) {
            preNode.next = null;
        } else {
            preNode.next = nexNode;
        }
        return tmp;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dump = new ListNode(0, head);
        ListNode first = dump.next;
        ListNode second = dump;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (null != first) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dump.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode tail = addNode(head, 1);
        tail = addNode(tail, 2);
        tail = addNode(tail, 3);
        tail = addNode(tail, 4);
        tail = addNode(tail, 5);
        print(removeNthFromEnd2(head.next, 2));
    }

    private static ListNode addNode(ListNode node, int v) {
        ListNode newNode = new ListNode(v);
        node.next = newNode;
        return newNode;
    }

    private static void print(ListNode node) {
        while (null != node) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}
