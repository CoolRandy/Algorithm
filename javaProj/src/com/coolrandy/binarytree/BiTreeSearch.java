package com.coolrandy.binarytree;

/**
 * Created by randy on 2016/3/13.
 * ���������  �����ָoffer 27��
 */
public class BiTreeSearch {

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

    /**
     * �ǵݹ�
     * @param root
     * @param target
     * @return
     */
    public static boolean biTreeSearch(TreeNode root, int target){

        TreeNode p = root;
        TreeNode q;

        if(null == p){
            return false;
        }

        while (p != null){
            if(target > p.data){
                q = p;
                p = p.right;
            }else {
                if(target < p.data){
                    q = p;
                    p = p.left;
                }else {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * �ݹ�
     */
    public static boolean recurBiTreeSearch(TreeNode root, int target){

        if(null == root){
            return false;
        }
        if(target > root.data){
            return recurBiTreeSearch(root.right, target);
        }else if(target < root.data){
            return recurBiTreeSearch(root.left, target);
        }else {
            return true;
        }
    }

    public static void main(String[] args){


    }
}
