package com.leetcode.tree_bfs;

import java.util.*;
/* traverse and store the nodes at each level in reverse order*/
/*This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. The only difference will be that instead of appending the current level at the end, we will append the current level at the beginning of the result list.*/

//expected o/p: [[9, 10, 5], [7, 1], [12]]
public class ReverseLevelOrder{
  public static List<List<Integer>> traverse(TreeNode root){
      List<List<Integer>> result = new LinkedList<>(); //used Linked List here
      if(root==null) return result;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      while(!queue.isEmpty()){
          int levelSize=queue.size();
          List<Integer> currentLevel = new ArrayList<>(); // used ArrayList here
          
          for(int i=0;i<levelSize;i++){
            TreeNode currentNode = queue.poll();
            // add the node to the current level
            currentLevel.add(currentNode.val);
                 // insert the children of current node to the queue
            if(currentNode.left!=null) queue.offer(currentNode.left);
            if(currentNode.right!=null) queue.offer(currentNode.right);

          }
          result.add(0,currentLevel);
      }
      return result;
  }
  public static void main(String args[]){
  TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrder.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }


   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
