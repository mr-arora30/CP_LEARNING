package com.leetcode.twopointers;

import java.util.*;
/*
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:
                      
Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
*/

class sortedArraySquares{

  public static void main (String args[]){
    int arr[] ={-2, -1, 0, 2, 3};
    System.out.println(Arrays.toString(makeSquares(arr)));
  }
  /*
  Approach 1 : An easier approach could be to first find the index of the first non-negative number in the array. After that, we can use Two Pointers to iterate the array. One pointer will move forward to iterate the non-negative numbers, and the other pointer will move backward to iterate the negative numbers. At any step, whichever number gives us a bigger square will be added to the output array
   O(N).
  Approach 2 : Since the numbers at both ends can give us the largest square, an alternate approach could be to use two pointers starting at both ends of the input array. At any step, whichever pointer gives us the bigger square, we add it to the result array and move to the next/previous number according to the pointer. O (N)


  */
  //Approach 2:
  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n];
    int highestSquareIdx = n - 1; //to keep track of elements in resultant array
    int left = 0, right = arr.length - 1; //left and right pointers
    while (left <= right) {
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];
      if (leftSquare > rightSquare) {
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }
    return squares;
  }
}