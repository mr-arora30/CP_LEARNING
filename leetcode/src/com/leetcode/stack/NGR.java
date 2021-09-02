import java.util.*;
/*
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1. 

Examples: 

For an array, the rightmost element always has the next greater element as -1.
For an array that is sorted in decreasing order, all elements have the next greater element as -1.
For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.  

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1
   */

   class NGR{

     /*
     Apprach 1: A brute force solution which will take input at ith index and iterate over
     jth index to check for nearest greater element.
     Time complexity for this approach is N^2.*/

      /*Approach 2: we will use stack , O(N) */

      //Approach 2:
     public static int[] nearestGreaterElement(int[] in){
        int ans[] = new int[in.length];
      ///[4, 5, 2, 25]
      int k=in.length-1;
        Stack<Integer> stack = new Stack<>();
        for(int i=in.length;i>=0;i--)
            stack.push(i);
       for(int i=0;i<in.length;i++){
          
          while( !stack.isEmpty() && stack.peek()<=in[i] ){
                
                  stack.pop();
          }
          if(stack.isEmpty()){
            ans[k--]=-1;
          }else{
            ans[k--]=stack.pop();
            stack.push(in[i]);
          }
       }
      return ans;
     }
     public static void main(String args[]){
       
     }
   }