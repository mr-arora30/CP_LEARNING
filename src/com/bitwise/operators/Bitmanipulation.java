package com.bitwise.operators;

/**
 * @author Rohit Arora << is left shift and multiplies by power of 2 so 1<<1
 *         means 2 1<<2 means 4 java uses 2's complement
 *
 */
public class Bitmanipulation {

	public static boolean isOdd(int n) {

		return (n & 1) > 0 ? true : false;
	}

	public static int getBit(int n, int i) {

		int mask = 1 << i;
		int bit = n & mask; // if greater than 0 then bit is 1 else 0
		return (bit > 0) ? 1 : 0;

	}

	public static int setBit(int n, int i) {
		int mask = 1 << i; // 1 left shift 2 is 100

		return n | mask; // for n is 5 and i is 1 then value is 111 which is 7

	}

	public static int clearBit(int n, int i) {

		int mask = ~(1 << i); // negating the mask so that the position at which we need clear becomes 0 and
								// rest all as 1 example 011

		// doing AND operation whith negated mask will clear the bit
		return n & mask;

	}

	public static int updateBit(int n, int i, int v) {
		// to update the bit at ith pos

		// first clear the bit at ith position
		int mask = ~(1 << i);
		int cleared_N = n & mask;

		// cleared bit number OR operation with the value bit V which is 0 or 1 to set
		// the bit
		int valueMask = v << i;

		n = cleared_N | valueMask;

		return n;

	}

	public static int clearIBits(int n, int i) {
		int mask = (~0) << i;
		int N = n & mask;

		return N;
	}

	public static int clearRangeItoJBits(int n, int i, int j) {

		/*
		 * 
		 * if range = 1 to 2 (starts from 0) n = 11111111 a part = 11111000 b part =
		 * 00000001 mask=a|b=11111001 n = 11111111 n &mask= 11111001 (ans)
		 */
		// build mask part a which is ~0 << j+1 bits
		// System.out.println(~0);
		int a = (~0) << (j+1);
		System.out.println(a);
		// build mask part b which is 1<<i -1 bits
		int b = (1 << i) - 1;
		System.out.println(b);
		// final mask = a|b
		int mask = a | b;
		System.out.println(mask);
		// ans is n & mask
		return n & mask;
		// return n & mask;
	}

	public static void main(String a[]) {
		int n = 15;
		int i = 1;
		int j = 2; // add j+1
		int v = 0;
		int updatedBit;
		System.out.println("Number is odd? :" + isOdd(n));
		System.out.println("bit at " + i + " position is: " + getBit(n, i));
		System.out.println("after setting the bit at " + i + " position value is : " + setBit(n, i));
		System.out.println("after clearing the bit at " + i + " position value is : " + clearBit(n, i));
		System.out.println(
				"after updating the bit at " + i + " with value " + v + " position value is : " + updateBit(n, i, v));
		updatedBit = updateBit(n, i, 0);
		System.out
				.println("after updating the bit at " + i + " with value " + v + " bit is : " + getBit(updatedBit, i));
		System.out.println();
		System.out.println();
		System.out.println("Cleared I range bits  for number " + n + " range of bits " + i + " value after Cleraing "
				+ clearIBits(n, i) // i is the number of bits you clear from right to left
		);

		System.out.println("Cleared J to I range bits  for number " + n + " range of bits from " + j + " to " + i
				+ " value after Cleraing " + clearRangeItoJBits(n, i, j) // i is the number of bits you clear from
																				// right to left
		);
	}

}
