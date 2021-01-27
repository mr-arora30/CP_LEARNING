package com.maths.III_LINEAR_RECURRENCES;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
/*
 * Problem : https://www.spoj.com/problems/SPP/
 */
public class MatrixExponentiation_02 {
	private static long MOD;
	static int k;
	static long n;
	static long m;
	static long b[];
	static long coff[];

	public static void main(String[] args) throws IOException {
		/*
		 * @formatter:on
		 * taking input
		 */
		BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			k = Integer.parseInt(br.readLine());
			k++;
			// a = new long[k + 1];
			b = new long[k + 1];
			coff = new long[k + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			// f vector

			for (int i = 2; i <= k; i++) {
				b[i] = Long.parseLong(st.nextToken());

			}
			// cofficients vector
			st = new StringTokenizer(br.readLine());
			coff[k] = 0;
			for (int i = 1; i < k; i++)
				coff[i] = Long.parseLong(st.nextToken());

			// the value of n,n and mod
			st = new StringTokenizer(br.readLine());
			m = Long.parseLong(st.nextToken());
			n = Long.parseLong(st.nextToken());
			MOD = Long.parseLong(st.nextToken());

			long ans1 = (compute(n) % MOD);
			long ans2 = (compute(m - 1) % MOD);
			long ans3 = (ans1 - ans2);
			ans3 += MOD;
			ans3 %= MOD;
			pw.println(ans3);
			pw.flush();

		}
		pw.close();
	}

	/**
	 * @param n ---> nth term
	 * @return -- nth term required result of the series
	 */
	private static long compute(long n) {

		// base case
		if (n == 0) {
			return 0;
		}
		if (n <= k) {
			// already this term is present
			return b[(int) (n)];
		}

		// otherwise use matrix exponention
		long f1[] = new long[k + 1];

		// Step 1 creating F vector
		for (int i = 2; i <= k; i++) {
			f1[i] = b[i];
			f1[1] = f1[1] + b[i];
		}
		// Step 2 creating TRANSFROMATION MATRIX
		long T[][] = new long[k + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 1) {
					if (j == 1)
						T[i][j] = 1;
					else
						T[i][j] = coff[(k + 1) - j];

				} else if (i < k) {
					// fill 0's and 1's in the for shifted Identity matrix
					// so that we can chunk out the first element in the series
					if (j == (i + 1)) {
						T[i][j] = 1;
					} else {
						T[i][j] = 0;
					}
				} else {
					/*
					 * This is the last row.
					 * Hence fill coefficients in reverse order
					 */
					if (j == 1) {
						T[i][j] = 0;
					} else
						T[i][j] = coff[(k + 1) - j]; // as coff array starts from index 1, and is of size k+1
					/*
					 * if coff matrix started from 0th index then
					 * T[i][j] = coff[k - j];
					 */
				}
			}
		}
		// step 3, Calculate T^n-1
		/*
		 * Here we already have sum upto K terms
		 */

		T = pow(T, n - (k - 1));

		// step 4 multiply T ^n-1 with f vector
		/*
		 * To get fn we need not multiply T matrix
		 * with complete vector
		 * what we do is we multiply only
		 * first row T with the F vector so that we get the fn value *
		 */

		long res = 0;
		for (int i = 1; i <= k; i++) {

			res = (res + (T[1][i] * f1[i]) % MOD) % MOD;
		}
		return res;

	}

	/**
	 * Fast Exponentiation
	 * 
	 * @param t --> Transfromation matrix
	 * @param p --> Power to which T matrix need to b raised
	 * @return--> T^n-1
	 *            Complexity Log N
	 */
	private static long[][] pow(long[][] t, long p) {

		if (p == 1)
			return t;

		if ((p & 1) == 1) {
			// power is odd

			return matrixMultiply(t, pow(t, p - 1));

		}

		long[][] X = pow(t, p / 2);

		return matrixMultiply(X, X);
	}

	/**
	 * @param a --> matrix 1 of 2 dimensions
	 * @param b --> matrix 2 of 2 dimensions
	 * @return ---> a x b
	 */
	private static long[][] matrixMultiply(long[][] a, long[][] b) {

		long c[][] = new long[k + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= k; j++) {
				for (int x = 1; x <= k; x++) {
					c[i][j] = (c[i][j] + (a[i][x] * b[x][j]) % MOD) % MOD;
				}

			}

		}
		return c;
	}
}
