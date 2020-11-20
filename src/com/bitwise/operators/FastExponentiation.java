package com.bitwise.operators;

/**
 * @author Rohit Arora Calculate a^y in O(log y) using fast exponentiation and
 *         using bitwise operations.
 *
 */
public class FastExponentiation {

	/**
	 * @param a
	 * @param y example a^5 = a^101 = a^4*a^1 so we extract each bit of y if bit is
	 *          1 then we multiply it by its a^1, pos
	 *          starts from 1, so first bit is a^1 if bit is 0, 
	 *          then we increment a=a*a; 
	 *          which is multipling a by its respective previous a^power.
	 *          so for 1st positon at the end it will be a=a^2
	 *          and for 2nd position at the end it will be a=^4
	 *          and for 3rd position at the end of while loop be a^8
	 *          ...
	 *          ...
	 *          
	 *    
	 * @return
	 */
	static int power_fast(int a, int y) {

		int ans = 1;
		// extract bits of y
		while (y > 0) {

			int last_bit = (y & 1); // 101 AND 001 =1

			if (last_bit == 1) {

				ans = ans * a;
			}
			a = a * a; //incrementing a by its previous power
			y = y >> 1;
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(power_fast(2, 8));

	}

}
