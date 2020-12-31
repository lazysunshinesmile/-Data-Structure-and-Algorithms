package com.mircrosoft.hard.study.utils;

import com.mircrosoft.hard.study.bean.ListNode;
import com.mircrosoft.hard.study.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    public static TreeNode string2TreeNode(String s) {
        s = s.substring(1, s.length()-1);
        String[] ss = s.split(",");
        System.out.println(ss.length);
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1; i<ss.length; i+=2) {
            TreeNode pa = queue.poll();
            if(!ss[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                pa.left = left;
                queue.add(left);
            }
            if(i+1<ss.length && !ss[i+1].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(ss[i+1]));
                pa.right = right;
                queue.add(right);
            }
        }

        return root;

    }
}
