package com.recursion_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohit Arora
 * https://leetcode.com/problems/count-vowels-permutation/
 */
public class CountVowelsPermutations {
	
	private static final int MOD = 1000000007;
	/*
	 * Either take array DP or Map for Top Down DP
	 */
	static long dp[][] = new long[('u' - 65) + 1][250000];
	Map<String, Long> map = new HashMap<String, Long>();

	public static void main(String[] args) {

		// Assigning each character to its respective row for top Down DP
		dp['a' - 65][0] = 'a';
		dp['e' - 65][0] = 'e';
		dp['i' - 65][0] = 'i';
		dp['o' - 65][0] = 'o';
		dp['u' - 65][0] = 'u';
		int n = 10;
		long a = solve(n, 'a');
		long e = solve(n, 'e');
		long i = solve(n, 'i');
		long o = solve(n, 'o');
		long u = solve(n, 'u');

		System.out.println((a + e + i + o + u) % MOD);
	}

	/**
	 * @param c   -- char
	 * @param n   -- length
	 * @param res -- count
	 *            This is recursive approach, here we try to find
	 *            the count of each vowel permutation using recursive
	 *            calls of n-1 chars
	 * 
	 *            * @return
	 */
	public static long solve(int n, char c) {
		if (n == 1)
			return 1;
		long res = 0;
		// Each vowel 'a' may only be followed by an 'e'.
		if (c == 'a')
			res = solve(n - 1, 'e') % MOD;
		// Each vowel 'e' may only be followed by an 'a' or an 'i'.
		if (c == 'e')
			res = (solve(n - 1, 'a') % MOD + solve(n - 1, 'i') % MOD) % MOD;
		// Each vowel 'i' may not be followed by another 'i'.
		if (c == 'i')
			res = (solve(n - 1, 'a') % MOD + solve(n - 1, 'e') % MOD + solve(n - 1, 'o') % MOD
					+ solve(n - 1, 'u') % MOD) % MOD;
		// Each vowel 'o' may only be followed by an 'i' or a 'u'.
		if (c == 'o')
			res = (solve(n - 1, 'i') % MOD + solve(n - 1, 'u') % MOD) % MOD;
		// Each vowel 'u' may only be followed by an 'a'.
		if (c == 'u')
			res = solve(n - 1, 'a') % MOD;

		return res;
	}

	/**
	 * @param n
	 * @param c
	 *          This Approach is Top Down apprach which is simply taking recursive
	 *          approach and saving its state and returning the state whenever
	 *          required.
	 * @return
	 */
	public long solve1(int n, char c) {

		/*
		 * if(map.containsKey(n+","+c))
		 * return map.get(n+","+c);
		 */
		if (n == 1)
			return 1;
		if (dp[c - 65][n] != 0)
			return dp[c - 65][n];

		long res;
		if (c == 'a')
			res = (solve1(n - 1, 'e')) % MOD;
		else if (c == 'e')
			res = (solve1(n - 1, 'a') + solve1(n - 1, 'i')) % MOD;
		else if (c == 'i')
			res = (solve1(n - 1, 'a') + solve1(n - 1, 'e') + solve1(n - 1, 'o') + solve1(n - 1, 'u')) % MOD;
		else if (c == 'o')
			res = (solve1(n - 1, 'i') + solve1(n - 1, 'u')) % MOD;
		else
			res = (solve1(n - 1, 'a')) % MOD;
		dp[c - 65][n] = res;
		// map.put(n+","+c,res);
		return res;
	}

	/*
	 * Tabular Bottom up DP approach, slightly modified conditions as per comments;
	 */
	public static int num(int n) {
		long[] current = new long[] { 1, 1, 1, 1, 1 };
		for (int i = 1; i < n; i++) {// a e i o u
			long[] next = new long[] { 0, 0, 0, 0, 0 };
			// Each vowel 'a' may only be followed by an 'e' or 'o'.
			next[1] += current[0];
			next[3] += current[0];
			// Each vowel 'e' may only be followed by an 'i'.
			next[2] += current[1];
			// next[2] += current[1];
			// Each vowel 'i' may not be followed by another 'i'.
			next[0] += current[2];
			next[1] += current[2];
			next[3] += current[2];
			next[4] += current[2];
			// Each vowel 'o' may only be followed by an 'i'
			next[2] += current[3];
			// next[4] += current[3];
			// Each vowel 'u' may only be followed by an //i.
			next[2] += current[4];
			// assign
			current[0] = next[0] % MOD;
			current[1] = next[1] % MOD;
			current[2] = next[2] % MOD;
			current[3] = next[3] % MOD;
			current[4] = next[4] % MOD;
		}
		return (int) ((current[0] + current[1] + current[2] + current[3] + current[4]) % MOD);

	}
}
