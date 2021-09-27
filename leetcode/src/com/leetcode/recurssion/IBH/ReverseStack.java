package com.leetcode.recurssion.IBH;

import java.util.*;

public class ReverseStack {
  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    System.out.println(stack);
    reverseStack(stack);
    System.out.println(stack);
  }

  public static void reverseStack(Stack<Integer> stack) {

    if (stack.isEmpty()) {
      return;
    }
    int temp = stack.pop();
    reverseStack(stack);
    insert(stack, temp);

  }
//[5,4,3,2,1] [4,3,2,1,5]
  public static void insert(Stack<Integer> stack, int temp) {
    if (stack.isEmpty()) {
      stack.push(temp);
      return;
    }
    int val = stack.pop();
    insert(stack, temp);
    stack.push(val);
    return;
  }
}