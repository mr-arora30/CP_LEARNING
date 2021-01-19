package com.recurssion_1;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.pow(5, 5));
		/// System.out.println(pw(5, 5));
		System.out.println(pwOp(5, 4));
	}

	public static int pw(int num, int n) {

		if (n == 1)
			return num;

		return num * pw(num, n - 1);
	}

	// fast power O(long N)->>
	// if n is odd then a * a^n-1
	// if n is even then (a^n/2)^2
	public static int pwOp(int num, int n) {
		if (n == 0)
			return 1;
		if ((n & 1) == 1) {

			return num * pwOp(num, n - 1);
		}
		n = n >> 1;
		return pwOp(num * num, n);

	}
}
