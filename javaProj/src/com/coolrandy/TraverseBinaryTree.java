package com.coolrandy;

import java.util.Queue;

/**
 * Created by randy on 2016/3/6.
 * 遍历二叉树：先序，中序，后序     递归和迭代
 */
public class TraverseBinaryTree {

    public static class BTnode{
        public int data;
        public BTnode left, right;

        public BTnode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void RecurPreOrder(BTnode root){

        if(null == root){
            return;
        }
        System.out.print(root.data + " ");
        RecurPreOrder(root.left);
        RecurPreOrder(root.right);
    }

    public static void createBTree(){

    }

    public static void main(String[] args){

        //create BTree

    }
}
