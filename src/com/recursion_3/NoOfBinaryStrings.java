package com.recursion_3;

import java.util.*;

public class NoOfBinaryStrings {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			// long dp[] = new long[n + 1];
			long dp[] = new long[n + 1];
			System.out.println(noOfBianaryStringWithoutConsecutiveOnes(n,dp));
			
		}
	}

	public static int noOfBianaryStringWithoutConsecutiveOnes(int n) {

		if (n == 0)
			return 1;
		if (n == 1)
			return 2;
		if (n < 0)
			return 0;

		int i =noOfBianaryStringWithoutConsecutiveOnes(n - 1)+ noOfBianaryStringWithoutConsecutiveOnes(n - 2); 
		return i;
	}

	public static long noOfBianaryStringWithoutConsecutiveOnes(int n, long dp[]) {

		if (n == 0)
			return 1;
		if (n == 1)
			return 2;

		if (dp[n] != 0)
			return dp[n];
		dp[n] = noOfBianaryStringWithoutConsecutiveOnes(n - 1, dp) + noOfBianaryStringWithoutConsecutiveOnes(n - 2, dp);
		return dp[n];
	}
}
