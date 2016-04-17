package com.coolrandy.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by randy on 2016/3/12.
 *
 * 采用递归和非递归的方式遍历二叉树
 */
public class GetBinaryDepth {

    public static class TreeNode{

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public GetBinaryDepth() {
        root = null;
    }

    /**
     * 递归创建二叉树
     * @param node
     * @param data
     */
    public void buildTree(TreeNode node,int data){
        if(root == null){
            root = new TreeNode(data);
        }else{
            if(data < node.data){
                if(node.left == null){
                    node.left = new TreeNode(data);
                }else{
                    buildTree(node.left,data);
                }
            }else{
                if(node.right == null){
                    node.right = new TreeNode(data);
                }else{
                    buildTree(node.right,data);
                }
            }
        }
    }
    /**
     * 递归实现
     */
    static int recurGetTreeDepth(TreeNode treeNode){

        if(null == treeNode){
            return 0;
        }

        int i = 1;
        int j = 1;

        if (treeNode.left != null){
            i += recurGetTreeDepth(treeNode.left);
        }

        if (treeNode.right != null){
            j += recurGetTreeDepth(treeNode.right);
        }

        return (i > j) ? i : j;
    }

    /**
     * 非递归实现
     */
    static int unRecurGetDepth(TreeNode treeNode){

        if (null == treeNode){
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            treeNode = queue.poll();
            if(treeNode.left != null){
                queue.add(treeNode.left);
            }

            if (treeNode.right != null){
                queue.add(treeNode.right);
            }
        }

        return depth;
    }



    public static void main(String[] args){

        int[] a = {2,4,12,45,21,6,111};
        GetBinaryDepth bTree = new GetBinaryDepth();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }

        int depth1 = recurGetTreeDepth(bTree.root);
        int depth2 = recurGetTreeDepth(bTree.root);

        System.out.println("tree depth1: " + depth1 + ", depth2: " + depth2);
    }
}
