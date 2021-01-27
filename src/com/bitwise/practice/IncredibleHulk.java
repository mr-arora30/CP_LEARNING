package com.bitwise.practice;

import java.util.Scanner;

/**
 * @author Rohit Arora
 *The Planet Earth is under a threat from the aliens of the outer
 * space and the Marvel Avengers team is busy fighting against 
 * them. Meanwhile, The Incredible Hulk has to defeat an enemy
 *  who is N steps above the level where he is standing 
 *  (assume it as the 0th level). Hulk, because of his incredible 
 *  jumping ability can take jumps in power of 2. In order to defeat 
 *  the enemy as quickly as possible he has to reach 
 *  the Nth step in minimum moves possible. Help Hulk to 
 *  find the same and contribute in saving the Mother Earth.


Input Format
The first line contains the number of test cases T. T test cases follow: The first line of each test case contains a number N.

Constraints
1 <= T <= 10
1 <= N <= 10^5

Output Format
Output T lines, containing the minimum number of moves required by Hulk to reach the Nth step

Sample Input
3
3
4
5
Sample Output
2
1
2
Explanation
Let total steps is n, find the nearest integer which is of power 2 and less then n. let it would be k. now remaining steps to cover is n-k and result = 1 + min steps for (n-k) remaining steps.
 */
public class IncredibleHulk {
/*
 * here problem is hulk can jump only at power of 2
 * so if enemy is at 13th level and as per question 
 * hulk is at 0th level
 * then hulk can jump upto 2^3 =8th level on first
 * after words hulk need to make 2^2 jump that will take him to 8+4=12th level
 * now to reach 13th level hulk need to make 2^1 jump so 12+1=13
 * if we notice then 
 * 13 is =1101 
 * which are in the form of powers of 2 for each bit(like we convert to decimal)
 * 1*2^0+0*2^1+1*2^2+1*2^3 =13
 * So SOLUTION to this problem is number of set bits
 */
	public static int no_of_Setbits(int n) {
		int ans = 0;
		while (n > 0) {
			n = n & (n - 1); // using Brain Kernighans O(no of setbits);
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.println(no_of_Setbits(sc.nextInt()));
		}
	}

}
