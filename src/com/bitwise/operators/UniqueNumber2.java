package com.bitwise.operators;

import java.util.Scanner;

/**
 * Question
 * 
 * @author Rohit Arora Question:We are given an array containg n numbers. All
 *         the numbers are present twice except for two numbers which are
 *         present only once. Find the unique numbers in linear time without
 *         using any extra space. ( Hint - Use Bitwise )
 *         Sample Input 
 *         4
 *         3 1 2 1
 *         Sample Output
 *         2 3 
 *         Explanation 
 *         Smaller number comes before larger number
 */
public class UniqueNumber2 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int size = sc.nextInt();
			int arr[]= new int[size];
				int first=0;
				int second=0;
				int res=0;
				int pos = 0;
		for(int i=0;i<size;i++) {
			
			
			arr[i]=sc.nextInt();
			res=res^arr[i];
					
		}
		//find position of first bit; example 100 postion is 2
		while((res&1)!=1) //unless this evaluates to 1 we keep on right shift and increment pos
		{
			pos++;
			res=res>>1;
		}
		
		//now create mask the help of pos by doing left shift
		
		int mask= 1<<pos;
		
		//now find out all the numbers in series which are having 
		//set bit at pos; by doing mask & number;
		
		for(int i=0;i<size;i++) {
			
			if((arr[i]&mask)>=1) {
				
				first= first^arr[i];
			}
		}
		second=first^res;
		System.out.println(1^2^3);
		System.out.print(((first>second) ?  second : first) +" "+ ((first<second) ?  second : first));
	}

}
