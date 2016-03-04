package com.coolrandy;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;
import java.util.ArrayList;

/**
 * Created by randy on 2016/3/4.
 * �����ӡһ��������������˼·��1���Ƚ�����ת��Ȼ�������ӡ  ʱ�临�Ӷ�ΪO(2N) ʹ����һ�������������ռ临�Ӷ�O(1)
 *                  2�����õݹ��ӡ�ķ�ʽ�������Ǵӵݹ�ĵײ���ʼ��ӡ��ʵ�ֵ���
 */
public class ReversePrintSingleList {

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * �ݹ��ӡ
     * @param listNode
     */
    public static void reversePrintList(ListNode listNode){

        if(listNode != null){
            reversePrintList(listNode.next);
            System.out.print(listNode.data + " ");
        }
    }

    /**
     * ����ţ�͵����ϵͳ���еı���
     * ���õ���Ȼ�ǵݹ飬�����ϲ��õ� ��ջ�ṹ
     */
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(listNode != null){
                list = printListFromTailToHead(listNode.next);
                list.add(listNode.data);
            }
            return list;
        }
    }

    /**
     * ��ת����
     * @param listNode
     */
    public static ListNode reverseSingleList(ListNode listNode){

        ListNode tempNode;
        ListNode prevNode = null;
        while (listNode.next != null){
            //���ȼ���listNode����һ�ڵ�
            tempNode = listNode.next;
            //��listNodeָ��prevNode����һ�ڵ�
            listNode.next = prevNode;
            //���ƽڵ�
            prevNode = listNode;
            listNode = tempNode;
        }
        listNode.next = prevNode;

        return listNode;
    }
    public static void main(String[] args){

        boolean isRecursion = true;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        if(isRecursion){
            long startTime = System.currentTimeMillis();
            reversePrintList(node1);
            long endTime = System.currentTimeMillis();
            System.out.print("\n run time is: ");
            System.out.print(endTime - startTime);

        }else {
            ListNode listNode = reverseSingleList(node1);
            do{
                System.out.print(listNode.data + " ");
                listNode = listNode.next;
            }while (listNode != null);
        }

    }
}
