package com.recursion_3;

public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move(5, "A", "B", "C");

	}
	public static void move(int n, String src, String helper, String dest) {
		if(n==0)
			return;
		move(n-1, src, dest, helper);
		System.out.println("Sifting from "+src+" to "+helper);
		move(n-1, helper, src, dest);
		
	}

}
