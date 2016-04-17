package com.coolrandy.binarytree;

import com.coolrandy.llinkedlist.SortLinklist;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by admin on 2016/3/28.
 *
 */
public class TraverseBinaryTree {

    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<Node> nodeList = null;

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node rootNode;

    public TraverseBinaryTree() {
        this.rootNode = null;
    }

    /**
     * 创建一个二叉树  采用递归创建
     * @param
     */

//    public void createBinaryTree(){
//
//        nodeList = new LinkedList<>();
//        for (int i = 0; i < array.length; i++){
//            nodeList.add(new Node(array[i]));
//        }
//
//    }

    public static void createBinaryTree(Node node, int value){

        if (null == rootNode){
            rootNode = new Node(value);
        }else {


        }
    }

    /**
     * 先序递归
     * @param root
     */
    public static void RecurPreOrder(Node root){

        if(null == root){
            return;
        }
        System.out.print(root.data);
        RecurPreOrder(root.left);
        RecurPreOrder(root.right);
    }

    /**
     * 非递归，采用迭代方式
     * 方式1，不借用top
     * @param root
     */
    public static void UnRecurPreOrder(Node root){
        if(null == root){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        stack.push(p);
        while (!stack.isEmpty()){
            p = stack.pop();
            System.out.print(p.data);
            if (p.right != null){
                stack.push(p.left);
            }
            if (p.left != null){
                stack.push(p.right);
            }
        }
    }

    public static void UnRecurPreOrder_1(Node root){

        if (null == root){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()){

            while (p != null){
                stack.push(p);
                System.out.print(p.data);
                p = p.left;
            }//p = null

            if (!stack.isEmpty()){
                p = stack.peek();
                stack.pop();
                p = p.right;
            }

        }
    }

    /**
     * 中序递归
     * @param root
     */
    public static void RecurInOrder(Node root){
        if (null == root){
            return;
        }

        RecurPreOrder(root.left);
        System.out.print(root.data);
        RecurPreOrder(root.right);

    }

    /**
     * 非递归中序遍历
     * @param root
     */
    public static void UnRecurInOrder(Node root){

        if (null == root){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()){

            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.print(p.data);
                p = p.right;
            }
        }
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public static void RecurPostOrder(Node root){

        if (null == root){
            return;
        }

        RecurPreOrder(root.left);
        RecurPreOrder(root.right);
        System.out.print(root.data);
    }

    /**
     * 非递归实现后序遍历
     * 1、双栈法
     * @param root
     */
    public static void UnRecurPostOrderDB(Node root){

        if (null == root){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node p = root;
        stack1.push(p);
        while (!stack1.isEmpty()){

            p = stack1.pop();
            stack2.push(p);
            if(p.left != null){
                stack1.push(p.left);
            }
            if (p.right != null){
                stack1.push(p.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
    }

    /**
     * 单栈法  这个理解起来稍微复杂一点。。。
     * @param root
     */
    public static void UnRecurPostOrderSB(Node root){

        if (null == root){
            return;
        }
        Node h = root;
        Stack<Node> stack = new Stack<>();
        stack.push(h);
        Node c = null;
        while (! stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && h != c.left && h != c.right){
                stack.push(c.left);
            }else if (c.right != null && h != c.right){
                stack.push(c.right);
            }else {
                System.out.print(stack.pop().data + " ");
                h = c;
            }
        }

        System.out.println();
    }
    public static void main(String[] args){

    }
}
