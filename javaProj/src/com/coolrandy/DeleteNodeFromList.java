package com.coolrandy;

/**
 * Created by randy on 2016/3/5.
 * ɾ�������еĽڵ�
 */
public class DeleteNodeFromList {

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * ���ֻ֪��Ҫɾ���Ľڵ㣬�����ʱ�临�Ӷ�O(1)�������ɾ���ýڵ�
     * ˼·�ܼ򵥣������ú�̽ڵ㸲�ǵ���Ȼ��ɾ����̽ڵ�   ע������û�п���ɾ���ڵ���β�ڵ�����,����β�ڵ�
     * ��û����O(1)��ʱ�临�Ӷ���ɾ������
     * ���Կ�������˫ָ�룬��O(n)��ʱ�临�Ӷ������β�ڵ�ɾ��,��ǰ����֪������ͷָ��,�ռ临�Ӷ�ΪO(1)
     * @param listNode
     */
    public static void deleteNode(ListNode head, ListNode listNode){

        if(listNode == null || null == head){
            return;
        }
        if(listNode != null && listNode.next != null) {
            listNode.data = listNode.next.data;
            listNode.next = listNode.next.next;
        }else if(null == listNode.next){
            ListNode priNode = head.next;
            while (priNode.next != null){
                head = head.next;
                priNode = priNode.next;
            }
            head.next = null;
        }
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode listNode = node1;
        deleteNode(listNode, node1);
        while (listNode != null){
            System.out.print(listNode.data + " ");
            listNode = listNode.next;
        }
    }
}
