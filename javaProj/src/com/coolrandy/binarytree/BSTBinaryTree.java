package com.coolrandy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by randy on 2016/4/10.
 * ������������ֳƶ���������
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
     * ��ӽڵ�
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
     * ɾ���ڵ�
     * @param value
     */
    public static void remove(int value){

        TreeNode target = getNode(value);
        //��Ϊ4���������
        if (null == target.left && null == target.right){

            if (root == target){
                //ɾ���ڵ���Ǹ��ڵ�
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

                //���ɾ���Ľڵ�����ڵ�
                if (target == target.parent.left){
                    target.parent.left = target.right;
                }else {
                    //ɾ�����Ǹ��ڵ���ҽڵ�
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

            //�ؼ����������ҽڵ����Ϊ�յ�����ǹؼ�
            //���ȿ������ɾ���ڵ�����ĸ��ڵ�����λ����ʱ��Ҫ���ǵ��������������ص��ˣ���ڵ��ǰ������������˳�������
            //����Ҳ����˵��target���������ϵĽڵ�Ԫ��ֵ����С�����ģ������������������Ľڵ���������ҽڵ�
            //���Ժ������Ҫ�����ҵ�target���������ҵ��ӽڵ�

            TreeNode maxLeftNode = target.left;
            while (maxLeftNode.right != null){
                maxLeftNode = maxLeftNode.right;
            }

            //ɾ���ýڵ�
            maxLeftNode.parent.right = null;
            maxLeftNode.parent = target.parent;
            if (target == target.parent.left){
                //ɾ�����Ǹ��ڵ����ڵ�
                target.parent.left = maxLeftNode;
            }else {
                target.parent.right = maxLeftNode;
            }

            maxLeftNode.left = target.left;
            maxLeftNode.right = target.right;
            //�ÿ�Ŀ��ɾ���ڵ�����ã���ֹ�ڴ�й¶
            target.parent = target.right = target.left = null;
        }
    }

    /**
     * ����ָ��Ԫ�ز��ҽڵ�
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
     * ���Ҷ���������е���Сֵ
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
     * ���Ҷ�������������ֵ
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
     * �ж�һ�ö������Ƿ�Ϊ���������  ������������ķ�ʽ�ж�
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
     * ����ֵΪvalue�Ľڵ�
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
     * ���������˼�룺
     * �Ƚ����ĸ��ڵ���ӣ�
     ������в��գ������ѭ��
     {
     ������Ԫ�س��ӣ����������
     ����ö���Ԫ�������ӣ�����������ӣ�
     ����ö���Ԫ�����Һ��ӣ������Һ������
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
