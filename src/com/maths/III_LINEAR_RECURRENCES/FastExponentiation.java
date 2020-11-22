package com.maths.III_LINEAR_RECURRENCES;

/**
 * @author Rohit Arora
 * Finding out power of a number in Log N time
 * 
 * Brute force method:
 * Loop
 * a*a*a...n times
 * end loop
 * Complexity = O(n)
 * 
 * Optimized approach:
 * for 5^11, here a=5, n=11
 * if n is odd --> a(a^n/2)^2
 * if n is even --> (a^n/2)^2
 * 
 *  Example :
 *  5^11						-- Step 1
 *  |
 *  -->5(5^5)^2					-- Step 2
 *  	  |
 *  	  -->5(5^2)^2			-- Step 3	
 *  			|
 *  			-->5(5^1)^2		 --Step 4
 *  				|
 *  				-->5(5^0)2	 -- Step 5 -->Total 5 steps
 *  
 *  Complexity = O(Log(n))
 *  
 *  
 */
public class FastExponentiation {
		static int count=0;
	/**
	 * @param a--> number
	 * @param n--> to the power
	 * @return --> a^n
	 * 
	 * This is recursive approach to the problem
	 * lets take the above example of 5^11 and expand as per the approach for Log N time
	 * 5^11						-- Step 1
	 *  |
	 *  -->5(5^5)^2					-- Step 2
	 *  	  |
	 *  	  -->5(5^2)^2			-- Step 3	
	 *  			|--n is even-->5^2 will happen and return in else part;  				
	 *  			-->5(5^1)^2		 --Step 4
	 *  				|
	 *  				-->5(5^0)2	 -- Step 5 -->Total 5 steps
	 */
	public static int FastExpo(int a, int n) {
		count++;
		if (n == 0) {
			/*
			 * base case when n becomes 0
			 */
			return 1;

		}
		int subprob = FastExpo(a, n / 2);

		if ((n & 1) == 1) {
			/*
			 * Case when power n is odd hence applying rules for odd
			 * Example : 5(5^1)^2
			 * 
			 * if n = 1 after the base case
			 * then => 5 * 1 * 1;
			 * 
			 * When n = 5
			 * then subprob(ans) = 5 * 25 * 25
			 * 
			 * When at last n=11
			 * then subprob(ans) = 5*((5 * 25 * 25)^2) = 5*5^10 =5^11
			 *
			 */
			return a * subprob * subprob;
		} else
			/*
			 * When  n is even 
			 * n=2
			 * then => 5 * 5 = 25 
			 * subprob(ans) = 25
			 * 
			 * then n=10
			 * => subprob(ans) = (5 * 25 * 25)^2 = 5^10
			 */
			return subprob * subprob;
	}

	public static void main(String[] args) {

		System.out.println(FastExpo(5, 10));
		System.out.println(count);
	}

}
