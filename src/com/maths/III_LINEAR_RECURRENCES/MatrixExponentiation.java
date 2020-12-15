package com.maths.III_LINEAR_RECURRENCES;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Rohit Arora
 * 		@formatter:off
 *         Matrix Exponentiation is a method by which we can find Nth term of
 *         a linear recurrence, an LA is given by
 *         f(i) = f(i-1) + f(i-2)....+f(i-n)
 *         -----------------------------------------------------------
 *         Steps to find nth term of LA is given by below:
 * 
 *         Step 1: Find the value of K ( no of terms on which f(i) depends,
 *         Example in the case of fibannaci series f(i) depends on previous 2
 *         value, so k would be 2).
 * 
 *         Step 2 : After getting K, Find out first K terms of the Sequence(This
 *         must be given in the problem).
 * 
 *         for fibanocci series first K terms of the sqeunce is given by 
 *         F1 = [0]
 *         		[1]
 *         
 *         Step 3 : Find out the Transformation Matrix T of size (K X K)
 *         T is given by shifted identity matrix and last row as reverse
 *         order of coffecients of the first K terms. Which is given as:
 *              
 *         [0		1		0		0	..	]
 *         [0		0		1		0 	..	]
 *         [0		0		0		1	..	]
 *         [:		:		:		:	..	]	
 *         [C<k>	C<k-1>	C<k-2>	..	C<1>]
 *        	
 *        for fibannaci series T is given by
 *  		T	= [0	1]
 *      		  [1	1]
 *      
 *			Step 4 : The F vector is given by K*1
 *				F = [	f<0>	]
 *					[	f<1>	]
 *					[	f<2>	]
 *					[ 	:		]
 *					[	f<k-1>	]		
 *      	
 *      	T * F<i> = F<i+1>
 *      
 *       => [0	1] [f<i-2>]	 = 	[	f<i-1>	]
 *      	[1	1] [f<i-1>] 	[	f<i>	]
 *      
 *      
 *      =>	 F<n> = T^n-1 X F<n-1>	
 *      
 *      Time Complexity is O(K^3 Log N)
 *         -------------------------------------------------------------
 *         Problem 1 on Matrix Exponentiation
 * 
 *         Sequence (ai) of natural numbers is defined as follows:
 * 
 *         ai = bi (for i <= k)
 *         ai = c1ai-1 + c2ai-2 + ... + ckai-k (for i > k)
 * 
 *         where bj and cj are given natural numbers for 1<=j<=k. Your task is
 *         to compute an for given n and output it modulo 109.
 * 
 *         Input
 *         On the first row there is the number C of test cases (equal to about
 *         1000).
 *         Each test contains four lines:
 * 
 *         k - number of elements of (c) and (b) (1 <= k <= 10)
 *         b1,...,bk - k natural numbers where 0 <= bj <= 109 separated by
 *         spaces
 *         c1,...,ck - k natural numbers where 0 <= cj <= 109 separated by
 *         spaces
 *         n - natural number (1 <= n <= 109)
 * 
 *         Output
 *         Exactly C lines, one for each test case: an modulo 109
 * 
 *         Example
 *         Input:
 *         3
 *         3
 *         5 8 2
 *         32 54 6
 *         2
 *         3
 *         1 2 3
 *         4 5 6
 *         6
 *         3
 *         24 354 6
 *         56 57 465
 *         98765432
 * 
 *         Output:
 *         8
 *         714
 *         257599514
 *
 */
public class MatrixExponentiation {
	
	private static final long MOD = 1000000000;
	static int k;
	static long n;
	long num;
	static long a[];
	static long b[];
	static long coff[];
	public static void main(String[] args) throws  IOException {
		/*
		 * @formatter:on
		 * taking input
		 */
		BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t--> 0) {
			k = Integer.parseInt(br.readLine());
			a = new long[k + 1];
			b = new long[k + 1];
			coff = new long[k + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			// f vector
			for (int i = 1; i <= k; i++)
				b[i] = Long.parseLong(st.nextToken());

			// cofficients vector
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++)
				coff[i] = Long.parseLong(st.nextToken());

			// the value of n
			n = Long.parseLong(br.readLine());

			pw.println(compute(n));
			pw.flush();
			
		}
		pw.close();
	}

	private static long compute(long n) {

		// base case
		if (n == 0) {
			return 0;
		}
		if (n <= k) {
			return b[(int) (n)];
		}

		// otherwise use matrix exponention
		long f1[] = new long[k + 1];

		// Step 1 creating F vector
		for (int i = 1; i <= k; i++) {
			f1[i] = b[i];
		}
		// Step 2 creating TRANSFROMATION MATRIX
		long T[][] = new long[k + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= k; j++) {

				if (i < k) {
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
					 * Hence fill coffecients in reverse order
					 */
					T[i][j] = coff[(k + 1) - j]; // as coff array starts from index 1, and is of size k+1
					/*
					 * if coff matrix started from 0th index then
					 * T[i][j] = coff[k - j];
					 */
				}
			}
		}
		// step 3, Calculate T^n-1

		T = pow(T, n - 1);

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
