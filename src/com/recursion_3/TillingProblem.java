package com.recursion_3;

import java.io.*;
import java.util.*;

public class TillingProblem implements Runnable {
	final static int MOD = 1000000007;
	static int level;

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		// System.out.println(countWays(n % MOD, m % MOD));
		new Thread(null, new TillingProblem(), "TillingProblem", 1 << 26).start();

	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine().trim());
			while (t-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken().trim());
				int m = Integer.parseInt(st.nextToken().trim());
				int dp[] = new int[100000];
				System.out.println(TopDownDpWays(n, m, dp));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static int ways(int n, int m) {

		if (n < m)
			return 1;

		int ways = ways(n - 1, m) % MOD + ways(n - m, m) % MOD;
		return ways;
	}

	public static int TopDownDpWays(int n, int m, int dp[]) {
		try {
			level++;
			if (n < m)
				return 1;
			if (dp[n] != 0)
				return dp[n];
			dp[n] = TopDownDpWays(n - 1, m, dp) % MOD + TopDownDpWays(n - m, m, dp) % MOD;
			return dp[n];
		} catch (StackOverflowError e) {
			System.out.println("n " + n);
			System.out.println("level " + level);
			return 0;
		}
	}

	static int countWays(int n, int m) {
		// table to store values
		// of subproblems
		int count[] = new int[n + 1];
		count[0] = 0;

		// Fill the table upto value n
		int i;
		for (i = 1; i <= n; i++) {

			// recurrence relation
			if (i > m)
				count[i] = (count[i - 1] % MOD + count[i - m] % MOD) % MOD;

			// base cases
			else if (i < m || i == 1)
				count[i] = 1;

			// i = = m
			else
				count[i] = 2;
		}

		// required number of ways
		return count[n];
	}

}
