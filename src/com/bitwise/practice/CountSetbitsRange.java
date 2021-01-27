package com.bitwise.practice;

import java.util.Scanner;

/**
 * @author Rohit Arora
 * Prateek Bhayia likes to play with bits. 
 * One day Prateek bhayia decides to assign a task to his student Sanya. 
 * You have help Sanya to complete this task. Task is as follows -
 *  Prateek Bhayia gives Q queries each query containing two integers a and b.
 * Your task is to count the no of set-bits in for all numbers between a and b (both inclusive)

Input Format
Read Q - No of Queries, Followed by Q lines containing 2 integers a and b.

Constraints
Q,a,b are integers.

Output Format
Q lines, each containing an output for your query.

Sample Input
2
1 1
10 15
Sample Output
1
17
 *
 */
public class CountSetbitsRange {

	public static int setBits(long a, long b) {
		int count = 0;

		while (a <= b) {
			long n = a;
			while (n > 0) {
				n = n & (n - 1);
				count++;
			}
			a++;
		}
		return count;
	}

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner(System.in); int t = sc.nextInt(); while (t-- > 0) {
		 * int a = sc.nextInt(); int b = sc.nextInt(); System.out.println(setBits(a,
		 * b)); }
		 */
		System.out.println(setBits(1, 63));
	}

}
