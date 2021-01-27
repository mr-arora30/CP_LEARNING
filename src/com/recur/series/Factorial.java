package com.recur.series;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(fact(5));

	}
	
	public static long fact(int n) {
		
		if(n==1 || n==0)
			return 1;
		return n * fact(n-1); // solution to the the subproblem leads to the solution for global problem
		
	}

}
