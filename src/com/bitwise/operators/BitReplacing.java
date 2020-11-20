package com.bitwise.operators;

/**
 * @author Rohit Arora
 * 
 * Question : You are given 2 32bit numbers N & M and 2 bit positions i and j
 * Write a method to set all bits b/w i and j in N equal to M(M becomes substring of N)
 * example:
 * N= 100000
 * M=	101
 *ANS=101010
 */
public class BitReplacing {

	/*
	 * Approach:
	 *  1. Clear bits in N from i to j
	 *  2. Shift M << i times
	 *  3. Do OR operation N|M
	 * 
	 */
	public static int replaceBits(int n , int m, int i, int j ) {
		int N = clearRangeItoJbits(n, i, j);
		//System.out.println(N);
		int M = (m<<i);
		//System.out.println(M);
		return N | M;
	}
	
	public static int clearRangeItoJbits(int n, int i, int j) {
		
		int a= (~0)<<(j+1);
		
		//2^n -1
		int b=(1<<i)-1;
		int mask= a|b;
		
		
		return n & mask;
		
	}
	public static void main(String[] args) {
	
		int n=15;//1000000000;
		int m=2;	//10101;
		//ans=1010101000;
		int i= 1;//3;
		int j=3;;
		System.out.println(replaceBits(n, m, i, j));
	}

}
