package com.recurssion_2;

import java.util.Arrays;

/**
 * @author Rohit Arora
 * 
 *         perform a linear search on an array
 *         and get its first occurrence
 *         using recursion
 *
 */
public class LinearSearch {
	static int arr[] = new int[15];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 7, 4, 1, 6, 7, 7, 10, 10 };
		// allOcc(a, 10, -1);
		// Arrays.fill(arr, -1);
		int size = lastOcc(a, 10, 7);
		System.out.println("size: " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}

	}

	/**
	 * @param a
	 * @param size
	 * @param num
	 *             This is simple for loop converision in recurssion
	 *             it simply check from last index to 0 index for the
	 *             presence of the key
	 * @return
	 */
	//this finds last occurrence
	public static int ls(int a[], int size, int num) {
		if (size < 0)
			return -1;
		if (a[size] == num)
			return size;
		return ls(a, size - 1, num);

	}

	/**
	 * @param a
	 * @param size
	 * @param key
	 * 
	 *             This is little tricky and better
	 *             it divides the problem into subproblems
	 *             where we check for presence of key in 2 sub arrays
	 *             if a[0] does not contain the key then we look into the
	 *             sub array of a[1 to n-1]
	 *             and finally we return index at i+1;
	 *             however time complexity will be more as we used Arrays.copyOf
	 * @return
	 */
	private static int firstOcc(int a[], int size, int key) {

		if (size == 0)
			return -1;
		if (a[0] == key)
			return 0;

		int i = firstOcc(Arrays.copyOfRange(a, 1, size), size - 1, key);

		if (i == -1)
			return -1;
		return i + 1;
	}

	private static int lastOcc(int a[], int size, int key) {
		/*
		 * if (size == -1)
		 * return -1;
		 * if (a[size] == key)
		 * return size;
		 * 
		 * int i = lastOcc(Arrays.copyOfRange(a, 0, size), size - 1, key);
		 * 
		 * if (i == -1)
		 * return -1;
		 * return i;
		 */

		// another approach

		if (size == 0)
			return -1;
		int i = lastOcc(Arrays.copyOfRange(a, 1, size), size - 1, key);
		if (i == -1) {
			if (a[0] == key)
				return 0;
			else
				return -1;
		}

		// otherwise if i returned by subporblem is not -1
		return i + 1;

	}

	private static void allOcc(int a[], int size, int key) {

		if (size == 0)
			return;
		if (a[a.length - size] == key)
			System.out.println(a.length - size);

		allOcc(a, --size, key);

	}

	/**
	 * @param a
	 * @param size
	 * @param j
	 * @param key
	 * @return
	 */
	private static int storeAllOcc(int a[], int size, int j, int key) {

		if (size == 0)
			return j;
		if (a[a.length - size] == key) {
			arr[j] = a.length - size;
			// j++; Another approach where we make a recursive call for j
			return storeAllOcc(a, --size, j + 1, key);
		}

		return storeAllOcc(a, --size, j, key);

	}

}
