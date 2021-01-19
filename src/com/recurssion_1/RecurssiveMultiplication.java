package com.recurssion_1;

public class RecurssiveMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(solve(5,6));
	}

	public static int solve(int a, int b) {
		if(b==1) {
			return a;
		}
		return a+solve(a,b-1);
	}
}
