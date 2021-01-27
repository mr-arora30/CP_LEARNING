package com.recur.series;

import java.util.Arrays;

public class checkSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 14 };
		System.out.println(anotherCheck(a, 4));
	}

	public static boolean check(int a[], int n) {
		if (n == 0 || n == 1) {
			return true;
		}
		if (a[0] < a[1] && check(Arrays.copyOfRange(a, 1, n), n - 1)) //Arrays.copyOf take O(n)
			return true;
		return false;

	}
	
	//faster than the above
	public static boolean anotherCheck(int a[], int n) {
		if(n==0 || n==1)
			return true;
		
		if(a[n-1]>a[n-2] && anotherCheck(a, --n)) {
			return true;
		}
		return false;
	}
}
