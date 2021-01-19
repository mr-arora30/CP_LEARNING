package com.recursion_1;

import java.util.*;
import java.io.*;

/**
 * @author Rohit Arora
 * 
 *         check if the given array is sorted or not using recursion
 *
 */
public class CheckSortArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int a[] = { 11, 2, 3, 4, 5 };
		System.out.println(checkSort(a, 5));
	}

	/**
	 * @param array
	 * @param array size
	 * 
	 *              we check if array[last element] > array[last element-1]
	 *              and f (n-1) array is sorted.
	 * 
	 * @return True>>if sorted else False
	 */
	public static boolean checkSort(int array[], int n) {

		// base case
		/*
		 * if array contains 1 or 0 elements
		 * then array is sorted.
		 */
		if (n == 0 || n == 1) {
			return true;
		}

		if ((array[n - 1] > array[n - 2]) && checkSort(array, n - 1)) {
			return true;
		}

		return false;

	}
}
