package com.leetcode.recurssion.IBH;

class PrintNums{

  public static void main(String args[]){
    /*
    Hypothesis
    if f(n) gives 1 to 7 then f(n-1) will give 1 to 6 
    Similarly if f(n) gives 7 to 1 then f(n-1) will give 6 to 7
      then we just need to prefix 7 + f(n-1)
    */
    print1ToN(7);
    printNTo1(7);

  }
  public static  void print1ToN(int n){

      if(n==0) // base condition
      return;

      print1ToN(n-1); // Hypothesis

     System.out.println(n); //Induction
  }
  public static void printNTo1(int n){

     if(n==0) // base condition
      return;
    System.out.println(n); //Induction
    printNTo1(n-1); // Hypothesis

  }
}