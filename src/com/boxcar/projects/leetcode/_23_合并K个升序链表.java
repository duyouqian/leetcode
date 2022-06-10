package com.boxcar.projects.leetcode;

import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _23_合并K个升序链表 {
    public static ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        } else if (n < 2) {
            return lists[0];
        } else {
            ListNode head = new ListNode(10001);
            ListNode tail = head;
            int finishCnt = 0;
            ListNode min = null;
            int minIndex = -1;
            while (true) {
                min = null;
                minIndex = -1;
                finishCnt = 0;
                for (int i = 0; i < n; ++i) {
                    ListNode tmp = lists[i];
                    if (null == tmp) {
                        ++finishCnt;
                        continue;
                    }
                    if (null == min || tmp.val <= min.val) {
                        min = tmp;
                        minIndex = i;
                    }
                }
                if (n == finishCnt) {
                    break;
                }
                tail.next = min;
                tail = tail.next;
                lists[minIndex] = lists[minIndex].next;
            }

            return head.next;
        }
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        return mergeKLists3(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists3(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return merge2Lists(mergeKLists3(lists, l, mid), mergeKLists3(lists, mid + 1, r));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        } else if (n < 2) {
            return lists[0];
        } else {
            ListNode head = lists[0];
            for (int i = 1; i < n; ++i) {
                head = merge2Lists(head, lists[i]);
            }
            return head;
        }
    }

    private static ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (null == list1 || null == list2) {
            return null == list1 ? list2 : list1;
        }
        ListNode head = new ListNode();
        ListNode tail = head, tmp1 = list1, tmp2 = list2;
        while (null != tmp1 && null != tmp2) {
            if (tmp1.val < tmp2.val) {
                tail.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tail.next = tmp2;
                tmp2 = tmp2.next;
            }
            tail = tail.next;
        }
        tail.next = null == tmp1 ? tmp2 : tmp1;
        return head.next;
    }

    public static void main(String[] args) {

    }
}
