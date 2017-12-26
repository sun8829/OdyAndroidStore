package com.ody.study.leetcode;

import org.junit.Test;

/**
 * Created by sunhuahui on 2017/12/26.
 */

public class AddTwoNumbers {


    @Test
    public void recursiveTest() {
        int sum = recursive(5);
        System.out.println("end : " + sum);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node;
        boolean isEnter = false;
        if (l1.val + l2.val >= 10) {
            node = new ListNode(l1.val + l2.val - 10);
            isEnter = true;
        } else {
            node = new ListNode(l1.val + l2.val);
        }

        if (l1.next != null && l2.next != null) {
            if (isEnter) {
                l1.next.val += 1;
            } else {
                node.next = addTwoNumbers(l1.next, l2.next);
            }
        } else if (l1.next == null && l2.next != null) {
            if (isEnter) {
                node.next = addTwoNumbers(new ListNode(1), l2.next);
            } else {
                node.next = addTwoNumbers(new ListNode(0), l2.next);
            }
        } else if (l1.next != null && l2.next == null) {
            if (isEnter) {
                node.next = addTwoNumbers(l1.next, new ListNode(1));
            } else {
                node.next = addTwoNumbers(l1.next, new ListNode(0));
            }

        } else if (isEnter) {
            node.next = new ListNode(1);
        }
        return node;
    }

    int recursive(int i) {
        int sum = 0;
        if (0 == i)
            return (1);
        else {
            System.out.println(i);
            sum = i * recursive(i - 1);
        }
        System.out.println("end : " + sum);
        return sum;
    }
}
