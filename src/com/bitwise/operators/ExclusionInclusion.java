package com.bitwise.operators;

import java.util.Scanner;

/**
 * @author Rohit Arora 
 * 		Question: find out the number of numbers between 1 and n
 *         which are divisible by any of the prime numbers less than 20.
 *         
 *         Sample Input
			5
			5
			10
			12
			15
			18
			
			Sample Output
			4
			9
			11
			14
			17
 *
 */
public class ExclusionInclusion {

	public static long totalNumbersDivisible(long N) {

		long prime[] = { 2, 3, 5, 7, 11, 13, 17, 19 };
		//long prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};

		long ans = 0;
		long count=0;

		long total_subsets = (1 << prime.length) - 1;
		// System.out.println(prime.length);
		System.out.println(total_subsets);

		for (int i = 1; i <= total_subsets; i++) {
 //count++;
			long denom = 1;
			int numberOfSetbits = Integer.bitCount(i);
			// System.out.println(numberOfSetbits);
			for (int j = 0; j < prime.length; j++) { // loop upto max number of bits
											// here prime.length will give 8
				count++;
				/*
				 * Mapping each bit to its respective prime by know at what position set bit is
				 * there
				 */
				if ((i & (1 << j)) >= 1) { // to create a mask 1 must be shifted j number of times

					denom = prime[j] * denom;

				}

			}
			/*
			 * counting number of set bits so that we can know which number has how many set
			 * bits if there are odd setbis then we add to ans else we subtract as per
			 * generalization for |A U B U C|
			 */
			if ((numberOfSetbits & 1) == 1) { // then odd
				ans = ans + (N / denom);
			} else {
				ans = ans - (N / denom);
			}

		}
System.out.println(count);
		return ans;

	}

	public static void main(String[] args) {

		System.out.println("ans "+totalNumbersDivisible(Long.MAX_VALUE));
		//System.out.println("ans "+totalNumbersDivisible(18));
		
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int t = sc.nextInt();
		 * 
		 * while ( t-->0) { int n = sc.nextInt();
		 * System.out.println(totalNumbersDivisible(n)); }
		 */
		 

	}

}
