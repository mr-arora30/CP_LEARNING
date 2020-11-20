package com.bitwise.practice;

import java.util.Scanner;

public class UN2 {
	public static int mask(int xor, int pos) {
		int mask=0;
		mask=1<<pos;
		return mask;
	}
	public static int getPos(int xor) {
		int pos=0;
		while((xor&1)!=1) {
			xor=xor>>1;
			pos++;
		}
		return pos;
	}
	public static void main(String[] args) {
		// get input
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[] = new int[t];
		int i=0;
		int xor=0;
		int num1=0;
		int num2=0;
		//loop input and store in array
		while(t-->0) {
			arr[i]=sc.nextInt();
			xor=arr[i]^xor;
			i++;
		}
		
		
		//create a mask to find last set bit
		int mask= mask(xor,getPos(xor));
		//gather all numbers present at that set bit position
		for (int j = 0; j < arr.length; j++) {
			if((arr[j]&mask)==1) {
				num1=num1^arr[j];
			}
		}
		// do xor on that group you will get your first number
		
		// do xor with the initail xor result with the first number you will get second number
		num2=num1^xor;
		System.out.println(((num1>num2) ? num2 : num1) + " "+ ((num1<num2) ? num2 : num1) );
		// or else gather set bits which are not there in that position and do xor to get second number;

	}

}
