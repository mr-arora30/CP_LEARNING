package com.bitwise.practice;

import java.util.Scanner;

/**
 * @author Rohit Arora
 *After the release of Avengers, Ironman and Thor got into a fight and Ironman challenged Thor to find out the number of numbers between 1 and n which are divisible by any of the prime numbers less than 20. Ironman being great at maths quickly answered the question but then Thor asked him to write a program for it. Ironman however found it quite difficult as he did not wanted to write so many lines of code. he knows that you are smart and can code this up easily. Can you do it?

Input Format
The first line consists of number of test cases t. then follow t lines which consists of number n for each test case.

Constraints
1 <= test cases <= 10 1 <= n <= 10^18

Output Format
the answer to each test case each in different line

Sample Input
5
5
10
12
15
18
Sample Output
4
9
11
14
17
Explanation
for n = 5 2 and 4 are divisible by 2 and 3 is divisible by 3 and 5 by 5. hence ans = 4.
 */
public class InclusionExclusionPractice {
/*
 * Total number of numbers divisible in the range upto (N) by a number M is given by N/M;
 */
	public static long isDivisible(int n) {
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19 };
		long ans = 0;
		long total_subsets = 1l << prime.length;

		for (int i = 1; i < total_subsets; i++) {
			long denom = 1;
			int setbits = Integer.bitCount(i);
			for (int j = 0; j < prime.length; j++) {

				if ((i & (1 << j)) >= 1) {
					denom = denom * prime[j];
				}
			}
			if ((setbits & 1) == 1) {
				// then odd
				ans += n / denom;
			} else {
				ans -= n / denom;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0) {
			System.out.println(isDivisible(sc.nextInt()));
		}
	}

}
