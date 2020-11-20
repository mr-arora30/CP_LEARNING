package com.bitwise.operators;

/**
 * @author Rohit Arora
 * This program is all about counting 1 bits in a number (counting set bits)
 * we have defiend 3 approaches
 * 1st one is least efficent take O(log k)
 * 2nd one is optimised and efficent takes O(no of 1(set) bits)
 * 3rd one is inbuilt java fucntion Integer.bitCount(int val);
 * 
 */
public class CountBits {
		
	/**
	 * @param N-> number
	 * This method is least efficent takes O(log k) time
	 * where k is the position of last 1 bit occuring in the number from left to right
	 * example: 00010011, here k=5
	 * 
	 * Here we do AND operation of N with 1 to to get last bit as 1 or not 
	 * if 1 then increment answer if 0 then answer is incremented with 0
	 * Then we right shift N to last bit which is 1. which is basically the at most number of bits
	 * a number can have
	 * @return ans--> number of set bits
	 */
	public static int countSetBits(int n) {
		
		int ans=0;
		while(n>0) {
			
			ans =ans+(n&1);
			n=n>>1;
						
		}
		return ans;
	}
	
	/**
	 * @param N--> number
	 * 
	 * This method is optimised and effiecnt and runs for O(no of 1(set) bits)
	 * 
	 * It does and operation between N and N-1 iteratively 
	 * and on each iteration ans is incremented.
	 * 
	 * Example:
	 * N	=	9	= 	1001
	 * N-1	=	8	=	1000 &
	 * ----------------------------------------
	 * AND			=	1000	ANS+1=1
	 * 
	 * N	=	8	=	1000
	 * N-1	=	7	=	0111 &
	 * ------------------------------------------
	 * AND 			=	0000	 ANS+1=2 --->no of set bits
	 * @return ans--> number of set bits
	 */
	public static int countSetBitsFast(int n) {
		int ans=0;
		
		while(n>0) {
			
			n= n & (n-1);
			ans++;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int n=14;

		System.out.println("1st method least efficent, no of set bits "+ countSetBits(n));
		System.out.println("2nd method optimised & efficent, no of set bits "+ countSetBitsFast(n));
		System.out.println("3rd method inbuilt and efficent, no of set bits "+ Integer.bitCount(n));
	}

}
