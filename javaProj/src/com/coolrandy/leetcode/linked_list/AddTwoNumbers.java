package com.coolrandy.leetcode.linked_list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by admin on 2016/4/8.
 * 输入： (2 -> 4 -> 3) + (5 -> 6 -> 4)   输出: 708
 */
public class AddTwoNumbers {

    public static class ListNode{

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 该方法的实现有点复杂，需考虑其他更好的算法
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode addTwoNums(ListNode node1, ListNode node2){

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head1 = node1, head2 = node2;
        ArrayList<Integer> list = new ArrayList<>();

        if (null == head1 && head2 != null){
            while (head2 != null){
                stack2.push(head2.data);
                head2 = head2.next;
            }
            while (!stack2.isEmpty()){
                list.add(stack2.pop());
            }
            return switchListToNode(list);
        }
        if (null == head1 && null == head2){
            return null;
        }
        if (null == head2 && head1 != null){
            while (head1 != null){
                stack1.push(head1.data);
                head1 = head1.next;
            }
            while (!stack1.isEmpty()){
                list.add(stack1.pop());
            }

            return switchListToNode(list);
        }

        while (head1 != null || head2 != null){
            if (head1 != null) {
                stack1.push(head1.data);
                head1 = head1.next;
            }
            if (head2 != null){
                stack2.push(head2.data);
                head2 = head2.next;
            }
        }

        int temp = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){

            if (stack1.isEmpty() && !stack2.isEmpty()){
                list.add(stack2.pop());
            }
            if (!stack1.isEmpty() && stack2.isEmpty()){
                list.add(stack1.pop());
            }
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                int s_pop1 = stack1.pop();
                int s_pop2 = stack2.pop();
                int all = s_pop1 + s_pop2 + temp;
                if (all >= 10) {
                    temp = all / 10;
                    list.add(all % 10);
                } else {
                    list.add(all);
                    temp = 0;
                }
            }
        }
        if(temp != 0){
            list.add(temp);
        }
        return switchListToNode(list);
    }

    public static ListNode switchListToNode(ArrayList<Integer> list){
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (int i: list){
            ListNode node = new ListNode(i);
            listNodes.add(node);
        }
        ListNode head = listNodes.get(0);
        ListNode temp = head;
        for (int i = 1; i < listNodes.size(); i++){
            temp.next = listNodes.get(i);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);


        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode node_1 = new ListNode(0);
        node_1.next = null;
        ListNode node_2 = new ListNode(0);
        node_2.next = null;

        ListNode node_3 = new ListNode(1);
        ListNode node_4 = new ListNode(8);
        node_3.next = node_4;
        node_4.next = null;
        ListNode node_5 = new ListNode(0);
        node_5.next = null;

        ListNode res = addTwoNums(node_3, node_5);//这里输出[8, 1]  预期结果却是[1, 8]
        while (res != null){
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

}
