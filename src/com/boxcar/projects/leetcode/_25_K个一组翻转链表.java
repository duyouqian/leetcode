package com.boxcar.projects.leetcode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 */
public class _25_K个一组翻转链表 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0, head);

        ListNode _dump = dump;
        while (true) {
            ListNode first = _dump;
            ListNode second = _dump;
            for (int i = 0; i < k; ++i) {
                if (null == first) {
                    break;
                }
                first = first.next;
            }
            if (null == first) {
                break;
            }
            ListNode nSecond = first.next;
            ListNode nFirst = second.next;
            first.next = null;

            ListNode newFirst = reverse(second, first);
            second.next = newFirst;
            nFirst.next = nSecond;

            _dump = nFirst;
        }

        return dump.next;
    }

    private static ListNode reverse(ListNode dump, ListNode last) {
        ListNode t = null, y = dump.next, r = null;
        while (null != y) {
            t = y.next;
            y.next = r;
            r = y;
            y = t;
        }
        return r;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 1; i < 6; ++i) {
            ListNode l = new ListNode(i);
            temp.next = l;
            temp = l;
        }
        reverseKGroup(head.next, 2);
    }
}
