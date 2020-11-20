package com.bitwise.practice;

import java.util.Scanner;

/**
 * @author Rohit Arora
 *We are given two coins of value x and y. We have to find the maximum of value of a XOR b where x <= a <= b <= y.

Input Format
We are given two integers x and y

Constraints
l <= r <= 1000

Output Format
Print the maximum value of a XOR b

Sample Input
5
6
Sample Output
3
Explanation
If a and b are taken to be 5. Then a xor b = 0
If a and b are taken to be 6. Then a xor b = 0
If a is 5 and b is 6. Then a xor b is 3.
 */
public class MaxXor {
	
	/**
	 * @param x
	 * @param y
	 * O(n^2)
	 * for 10^18 =64bit it will take 10^36 which is a lot.
	 * @return
	 */
	public static int bruteForceMethod(int x, int y) {
		int max=0;
		int a=x;
		int b=y;
	/*
	 * while(b>a) { max= Math.max(max, a^b); b--; }
	 */
		for (int i = a; i <= b; i++) {
			for (int j = i; j <= b; j++) {
				max= Math.max(max, i^j);
			}
			
		}
		return max;
		
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 * O(Log M) where M is number of bits.
	 * if it was an array of numbers where we had to find max xor pair
	 * then O(N log M) where N is size of array
	 */
	public static int efficientMaxXor(int x, int y) {
		int mask;
		// mask = 1 <<
		int vis = 0;
		int ans;

		for (int i = 30; i >= 0; i--) {
			mask = 1 << i;
			// System.out.println(Integer.toBinaryString(mask));
			if(vis==0) {
			if (((x & mask) ^ (y & mask)) > 1) {
				vis++;
			}
			}
			else
			if (((x & mask) ^ (y & mask)) == 0) {

				if ((x & mask) == 0) {
					x = x | mask;
				} else {
					y = y & (~mask);
				}
			}

		}

		return x ^ y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		// System.out.println(bruteForceMethod(x, y));
		System.out.println(efficientMaxXor(x, y));

	}

}
