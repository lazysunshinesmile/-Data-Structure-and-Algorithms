package com.mircrosoft.hard.study.utils;

import com.mircrosoft.hard.study.bean.ListNode;

import java.util.List;

public class Utils {
    public static ListNode arr2ListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i=0; i<arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return dummy.next;
    }

    //1->2->3  =>...
    public static ListNode string2ListNode(String ss) {
        String[] values = ss.split("->");
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for(int i=0; i<values.length -1; i++) {
            int val = Integer.parseInt(values[i]);
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;
        }
        return pre.next;
    }

    public static String print(ListNode head) {
        ListNode temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(temp != null) {
            stringBuilder.append(temp.val + "->");
            temp = temp.next;
        }
        stringBuilder.append("null");

        return stringBuilder.toString();
    }
}
