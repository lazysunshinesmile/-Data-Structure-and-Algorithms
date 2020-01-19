package com.sun.sort.algorithm;


// Definition for singly-linked list.

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
         ListNode temp = this;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        return this.val + "";
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}


public class AddTwoNumbers {

    public static void main(String[] args) {
       AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(5), new ListNode(5)));

    }

    private void buquan(ListNode l1, ListNode l2) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode ret = null;
        ListNode start = null;
        boolean first = true;
        int k = 0;
        do {
            int l1val = 0;
            if(l1 != null) {
                l1val = l1.val;
            }

            int l2val = 0;
            if(l2 != null) {
                l2val = l2.val;
            }
             int sum = l1val + l2val + k;
            k = sum /10;
            if(first) {
                ret = new ListNode(sum % 10);
                start = ret;
                first =false;
            }else  {
                ret.next = new ListNode(sum % 10);
                ret = ret.next;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        } while(l1 != null || l2 != null) ;
        if(k != 0) {
            ret.next = new ListNode(k);
        }
        return start;
    }

//2-》4-》3  == 342
    private BigInteger getRealNumber(ListNode l) {
        //ret=2 l.val=4
        long start = 0L;
        BigInteger ret = new BigInteger("0");

        int k = 0;
        while(l != null) {
             ret = ret.add(new BigInteger(l.val * (long)Math.pow(10, k++) + ""));
             l = l.next;
        }
        return ret;
    }


    private ListNode getListNode(long number) {
        ListNode start = null;
        ListNode node = null;
        boolean first = true;
        do {
            int n = (int)(number % 10);
            ListNode temp = new ListNode(n);
            if(first) {
                start = temp;
                node = temp;
                first = false;
            }else {
                node.next = temp;
            }
            node = temp;

            number = number /10;
        }while(number != 0);
        return start;
    }
    private long getRealNumber2(ListNode l) {
        StringBuilder stringBuilder = new StringBuilder();
        while(l != null) {
            stringBuilder.insert(0, l.val);
            l = l.next;
        }
        return Long.parseLong(stringBuilder.toString());
    }
}
