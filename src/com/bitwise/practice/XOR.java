package com.bitwise.practice;

import java.util.Scanner;

public class XOR {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
	//	sc.next();
		while(t-->0) {
			String a = sc.next();
			String b = sc.next();
			//String arr[] = a.split(" ");
			
			int a1 = Integer.parseInt(a, 2);
			int a2 = Integer.parseInt(b, 2);
			String ans =Integer.toBinaryString(a1^a2);
			int siz = a.length()-ans.length();
			while (siz >0) {
				
				ans='0'+ans;
				siz--;
			}
			System.out.println(ans);
		
		}
	}

}
