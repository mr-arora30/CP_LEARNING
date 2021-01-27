package com.bitwise.practice;

public class MinXOR {

	public static void main(String[] args) {
		long n=21;
		
		
		/*
		 * lets get first set bit
		 */
		long n1=n;
		int first_set_bit=0;
		while(n1>0) {
			if((n1&1)==1) {
				break;
			}
			n1=n1>>1;
			first_set_bit++;
		}
		long a = 1<<first_set_bit;
		
		long n2=n;
		/*
		 * lets get second part
		 * make everything 0 upto first part 
		 */
		long b=n2 &((~0l)<<(first_set_bit+1));
		System.out.println(a);
		System.out.println(b);
		System.out.println(a^b);
	}

}
