package com.bitwise.operators;

import java.util.Scanner;

/**
 * Question
 * 
 * @author Rohit Arora Question: We are given an array containg n numbers. All
 *         the numbers are present thrice except for one number which is only
 *         present once. Find the unique number. Only use - bitwise operators,
 *         and no extra space.
 *         Sample Input
 *         7
 *         1 1 1 2 2 2 3
 *         Sample o/p
 *         3
 *         note this cannot handle negative test cases
 */
public class UniqueNumber3 {

	public static void main(String[] args) {
		int ans=0;
		Scanner sc =  new Scanner(System.in);
		int size = sc.nextInt();
		int arr[]= new int[64]; //constant time
		while(size>0) {
			
			int no = sc.nextInt();
			int j=0;
			
			// go upto the last bit of the number
			while(no>0) {
				
				// check if the bit is 1 if 1 then increment array at that position
				if((no&1)==1) {
					arr[j]++;
				}
				
				j++;
				no =no>>1;
				
			}
			
			
			size--;
		}
		int p=1; //intialize for power of 2
		
		for (int i = 0; i < arr.length; i++) {
				
				arr[i]%=3;
			
				ans+=arr[i]*p; // converting binary to decimal
				p= p<<1;			
				
		}
		System.out.println(ans);
		
	}

}
