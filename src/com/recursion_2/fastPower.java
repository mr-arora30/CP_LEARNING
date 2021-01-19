package com.recursion_2;

public class fastPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(power(5l, 9999999999l));
		System.out.println(fastPow(5, 6));

	}

	// basic non optimized

	public static long power(long a, long n) {

		/// if (n == 0)
		// return 1;
		// return a * power(a, n - 1);
		long ans = a;
		while (n > 1) {
			ans = ans * a;
			n--;
		}
		return ans;
	}

//optimized O(long N) time
	//if n is odd then a * a^n-1 or a * a^2
	// if n is even then (a^n/2)^2
	public static long fastPow(long a, long n) {
		if (n == 0)
			return 1;

		long smaller_ans = fastPow(a, n / 2);
		smaller_ans *= smaller_ans;
		if (n % 2 == 1)
			return smaller_ans * a;

		return smaller_ans;

		/*
		 * similar approach by me
		 * if (n % 2 == 1) {
		 * return a * fastPow(a, n - 1);
		 * }
		 * n = n >> 1;
		 * return fastPow(a * a, n );
		 */

	}
}