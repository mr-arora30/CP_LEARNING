package com.leetcode.recurssion.IBH;

import java.util.*;

/*Using same hypothesis and induction as Sorted Array problem, just at base condition of insert is modified as here the stack top needs to be the smallest and bottom of the stack is largert*/
public class SortStack {
  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<>();
    stack.push(4);
    stack.push(3);
    stack.push(10);
    stack.push(1);
    sortAStack(stack);
    System.out.println(stack);
    System.out.println(stack.pop());

  }

  public static void sortAStack(Stack<Integer> stack) {
    if (stack.size() == 1)
      return;

    int temp = stack.pop();
    // System.out.println(stack.size());
    sortAStack(stack);
    insert(stack, temp);
  }

  public static void insert(Stack<Integer> stack, int temp) {
    if (stack.size() == 0 || stack.peek() >= temp) {
      stack.push(temp);
      return;
    }

    int val = stack.pop();
    insert(stack, temp);
    stack.push(val);
    return;
  }

}