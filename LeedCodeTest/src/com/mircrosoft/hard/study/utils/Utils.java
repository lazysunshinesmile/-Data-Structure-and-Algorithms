package com.mircrosoft.hard.study.utils;

import com.mircrosoft.hard.study.bean.ListNode;

public class Utils {
    public ListNode string2ListNode(String ss) {
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

    public String print(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while(head != null) {
            stringBuilder.append(head.val + "->");
            head = head.next;
        }
        stringBuilder.append("null");

        return stringBuilder.toString();
    }
}
