package com.mircrosoft.hard.study.utils;

import com.mircrosoft.hard.study.bean.ListNode;
import com.mircrosoft.hard.study.bean.Node;

import java.util.*;

public class Utils {
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

    public static ListNode array2ListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int a:arr) {
            ListNode temp = new ListNode(a);
            curr.next = temp;
            curr = temp;
        }

        return head.next;
    }

    public static String print(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while(head != null) {
            stringBuilder.append(head.val + "->");
            head = head.next;
        }
        stringBuilder.append("null");

        return stringBuilder.toString();
    }

    /**
     * arr 为二维数组,i为父节点，arr[i][0]...arr[i][j]为父节点的邻居节点
     * @param arr
     * @return
     */
    public static Node array2Node(int[][] arr) {
        Map<Integer, Node> map = new HashMap<>();
        Node ret = null;
        for(int i=0; i<arr.length; i++) {
            Node p = map.getOrDefault(i+1, new Node(i+1));
            map.put(i+1, p);
            for(int j=0; j<arr[i].length; j++) {
                Node s = map.getOrDefault(arr[i][j], new Node(arr[i][j]));
                map.put(arr[i][j], s);
                p.neighbors.add(s);
            }
            ret = p;
        }

        return ret;
    }

    public static void print(Node node) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        List<Node> visited = new LinkedList<>();
        while(!nodes.isEmpty()) {
            Node cur = nodes.remove();
            if(visited.contains(cur)) {
                continue;
            }
            visited.add(cur);
            System.out.print(cur.val + ", ");
            for(Node next: cur.neighbors) {
                nodes.add(next);
            }
        }

    }
}
