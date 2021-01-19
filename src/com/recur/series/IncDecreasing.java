package com.recur.series;

public class IncDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//inc(5);
		dec(5);
	}

	public static void inc(int n) {

		if (n == 0)
			return;
		inc(n - 1);
		System.out.println(n);
	}

	public static void dec(int n) {

		if (n == 0)
			return;
		System.out.println(n);
		dec(n - 1);

	}

}
