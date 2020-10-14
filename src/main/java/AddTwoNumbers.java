/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author su
 * @date 2020-10-14 21:44
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * Related Topics 链表 数学
 */


public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode head = AddTwoNumbers.addTwoNumbers(l1, l2);
        ListNode original = head;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        ListNode afterReverse = reverse(original);
        while (afterReverse != null) {
            System.out.println(afterReverse.val);
            afterReverse = afterReverse.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            // 相加
            int value = v1 + v2 + carry;
            tail.next = new ListNode(value % 10);
            tail = tail.next;
            carry = value / 10;
            // 往前推进
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

        }
        return head.next;

    }

    /**
     * 反转链表
     *
     * @param head 头结点
     * @return 反转后头结点
     */
    public static ListNode reverse(ListNode head) {
        ListNode preNode = head;
        ListNode curNode = preNode.next;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        // 清空头结点
        head.next = null;
        return preNode;
    }

    /**
     * 节点定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
