package com.bitwise.practice;

import java.util.Scanner;

public class UN3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[] = new int[64];
		while (t-- >0) {

			int n = sc.nextInt();
			int j = 0;
			while (n > 0) {
				arr[j] += (n & 1);
				n = n >> 1;
				j++;
			}
			
			

		}
		int p=1;
		int ans=0;
		for (int i = 0; i < arr.length; i++) {
			arr[i]%=3;
			ans+=arr[i]*p;
			p=p*2;
		}
		
		System.out.println(ans);
	//	System.out.println(Integer.toBinaryString(100));
	}

}
