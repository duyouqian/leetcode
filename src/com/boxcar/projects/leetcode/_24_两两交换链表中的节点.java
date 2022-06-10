package com.boxcar.projects.leetcode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class _24_两两交换链表中的节点 {
    public static ListNode swapPairs(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode first = newHead;
        ListNode second = first.next;
        ListNode third = second.next;

        while (null != third) {
            first.next = third;
            second.next = third.next;
            third.next = second;

            first = second;
            if (null == first) {
                break;
            }
            second = first.next;
            if (null == second) {
                break;
            }
            third = second.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
