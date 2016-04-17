package com.coolrandy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by randy on 2016/4/10.
 * 二叉查找树，又称二叉排序树
 * http://blog.csdn.net/sheepmu/article/details/38407221
 */
public class BSTBinaryTree {

    public static class TreeNode{
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode parent, TreeNode left, TreeNode right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    private static TreeNode root;
    public BSTBinaryTree() {
        root = null;
    }

    public BSTBinaryTree(int value){
        root = new TreeNode(value, null, null, null);
    }


    /**
     * 添加节点
     * @return
     */
    public static void add(int value){
        if (null == root){
            root = new TreeNode(value, null, null, null);
        }else {

            TreeNode currNode = root;
            TreeNode parent = null;
            do {
                parent = currNode;
                if (value > parent.value){
                    //
                    currNode = currNode.right;
                }else {
                    currNode = currNode.left;
                }
            }while (currNode != null);
            TreeNode node = new TreeNode(value, parent, null, null);
            if (value > parent.value){
                parent.right = node;
            }else {
                parent.left = node;
            }
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public static void remove(int value){

        TreeNode target = getNode(value);
        //分为4种情况讨论
        if (null == target.left && null == target.right){

            if (root == target){
                //删除节点就是根节点
                root = null;
            }else {
                if (target == target.parent.left){
                    target.parent.left = null;
                }else {
                    target.parent.right = null;
                }

                target.parent = null;
            }

        }else if (null == target.left && target.right != null){

            if (root == target){
                root = target.right;
            }else {

                //如果删除的节点是左节点
                if (target == target.parent.left){
                    target.parent.left = target.right;
                }else {
                    //删除的是父节点的右节点
                    target.parent.right = target.right;
                }

                target.right.parent = target.parent;
                target.right = null;
                target.parent = null;

            }
        }else if (target.left != null && null == target.right){

            if (root == target){
                root = target.left;
            }else {

                if (target == target.parent.left){
                    target.parent.left = target.left;
                }else {
                    target.parent.right = target.left;
                }

                target.left.parent = target.parent;

                target.left = null;
                target.parent = null;
            }
        }else if (target.left != null && target.right != null){

            //关键是这种左右节点均不为空的情况是关键
            //首先考虑如果删除节点该由哪个节点来补位，这时就要考虑到二叉排序树的特点了，其节点是按照中序遍历的顺序排序的
            //所以也就是说在target的左子树上的节点元素值都是小于他的，但是在其子树中最大的节点就是最后的右节点
            //所以后面就是要遍历找到target子树中最右的子节点

            TreeNode maxLeftNode = target.left;
            while (maxLeftNode.right != null){
                maxLeftNode = maxLeftNode.right;
            }

            //删除该节点
            maxLeftNode.parent.right = null;
            maxLeftNode.parent = target.parent;
            if (target == target.parent.left){
                //删除的是父节点的左节点
                target.parent.left = maxLeftNode;
            }else {
                target.parent.right = maxLeftNode;
            }

            maxLeftNode.left = target.left;
            maxLeftNode.right = target.right;
            //置空目标删除节点的引用，防止内存泄露
            target.parent = target.right = target.left = null;
        }
    }

    /**
     * 根据指定元素查找节点
     * @param value
     * @return
     */
    public static TreeNode getNode(int value){

        TreeNode currNode = root;
        do {
            if (value > currNode.value){
                currNode = currNode.right;
            }else if (value < currNode.value){
                currNode = currNode.left;
            }else {
                break;
            }
        }while (currNode != null);
        return currNode;
    }

    /**
     * 查找二叉查找树中的最小值
     * @param node
     * @return
     */
    public static TreeNode findMin(TreeNode node){
        if (null == node){
            return null;
        }
        while (node != null){
            node = node.left;
        }
        return node;
    }

    /**
     * 查找二叉查找树的最大值
     * @param node
     * @return
     */
    public static TreeNode findMax(TreeNode node){
        if (null == node){
            return null;
        }
        while (node != null){
            node = node.right;
        }
        return node;
    }

    /**
     * 判断一棵二叉树是否为二叉查找树  采用终须遍历的方式判断
     * @param root
     * @return
     */
    public static boolean judgeBST(TreeNode root){

        if (null == root){
            return true;
        }
        int prevData = Integer.MIN_VALUE;
        boolean b1, b2;
        b1 = judgeBST(root.left);
        if (!b1 || prevData > root.value){
            return false;
        }
        prevData = root.value;
        b2 = judgeBST(root.right);
        return b2;
    }

    /**
     * 查找值为value的节点
     * @param node
     * @param value
     * @return
     */
    public static TreeNode searchSpecNode(TreeNode node, int value){

        return null;
    }

    public static void bst(){

    }

    /**
     * 层序遍历的思想：
     * 先将树的根节点入队，
     如果队列不空，则进入循环
     {
     将队首元素出队，并输出它；
     如果该队首元素有左孩子，则将其左孩子入队；
     如果该队首元素有右孩子，则将其右孩子入队
     }
     * @param
     */
    public static void levelOrderTraverse(TreeNode root){

        Queue queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = (TreeNode)queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args){

        BSTBinaryTree tree = new BSTBinaryTree();
        tree.add(5);
        tree.add(20);
        tree.add(10);
        tree.add(3);
        tree.add(8);
        tree.add(15);
        tree.add(30);
        tree.add(32);
        tree.add(27);
        tree.add(18);

        levelOrderTraverse(root);

        System.out.println("\n" + judgeBST(root));

        //5 3 20 10 30 8 15 27 32 18
        //true

        remove(20);
        levelOrderTraverse(root);
        //5 3 18 10 30 8 15 27 32
    }
}
