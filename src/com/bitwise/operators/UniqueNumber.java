package com.bitwise.operators;



/** Question
 * @author Rohit Arora
 * Question: find unique number in a given series(every number occurs ONLY TWICE except 1) which is not repeating itself without using any extra space
 * sol: use XOR on all numbers by expoliting the property of XOR a ^ b ^ a =b
 *
 */
public class UniqueNumber {

	public static void main(String[] args) {
		
		int num[] = {3,1,1,3,4};//all numbers should occur twice except 1;

		int ans = 0;
		for (int i = 0; i < num.length; i++) {
			
			
			ans = ans ^ num[i];
			
		}
		System.out.println(ans);
	}

}
