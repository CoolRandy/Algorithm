package com.coolrandy.stackqueue;

import java.util.Stack;

/**
 * Created by randy on 2016/3/30.
 * 采用两个栈实现队列，  实现队列的两个方法即删除队列头、插入队列尾
 *
 * 主要是分析栈和队列的特性
 *
 */
public class CreateQueueByStack {

    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

    public static void appendToTail(Stack<Integer> stack1, int target){

        stack1.push(target);
    }

    public static int deleteHead(Stack<Integer> stack1, Stack<Integer> stack2){

        if (stack2.size() <= 0) {

            while (stack1.size() > 0) {

                int temp = stack1.peek();
                stack1.pop();
                stack2.push(temp);
            }
        }

        if (stack2.isEmpty()){
            try {
                throw new Exception("Empty stack!");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){

        CreateQueueByStack createQueueByStack = new CreateQueueByStack();

        createQueueByStack.appendToTail(stack1, 1);
        createQueueByStack.appendToTail(stack1, 2);
        createQueueByStack.appendToTail(stack1, 3);

        createQueueByStack.deleteHead(stack1, stack2);

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop() + " ");
        }
        System.out.print("\n");
        createQueueByStack.appendToTail(stack1, 5);
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop() + " ");
        }
    }

}
