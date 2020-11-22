package com.maths.III_LINEAR_RECURRENCES;

public class FastExponentiation {
		static int count=0;
	public static int FastExpo(int a , int n) {
		count++;
		if(n==0) {
			return 1;
			
		}
		int subprob= FastExpo(a, n/2);
		
		if((n&1)==1) {
			return a * subprob * subprob;
		}
		else 
			return subprob * subprob;
	}
	public static void main(String[] args) {

		System.out.println(FastExpo(5,10));
		System.out.println(count);
	}

}
