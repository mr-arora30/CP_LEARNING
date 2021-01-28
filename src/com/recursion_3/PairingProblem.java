package com.recursion_3;

import java.util.*;

public class PairingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long dp[] = new long[n + 1];

			System.out.println(pairTopDownDP(n, dp));
			System.out.println(pairBottomUpDP(n));
			System.out.println(pair(n));
		}
	}

	public static long pair(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		long p = pair(n - 1) + (n - 1) * pair(n - 2);
		return p;

	}

	public static long pairTopDownDP(int n, long dp[]) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (dp[n] != 0)
			return dp[n];
		dp[n] = pairTopDownDP(n - 1, dp) + (n - 1) * pairTopDownDP(n - 2, dp);
		return dp[n];

	}

	static long pairBottomUpDP(int n) {
		long dp[] = new long[n + 1];

		// Filling dp[] in bottom-up manner using
		// recursive formula explained above.
		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
		}

		return dp[n];
	}
}
