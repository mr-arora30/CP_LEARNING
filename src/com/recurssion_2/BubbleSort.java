package com.recurssion_2;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Rohit Arora
 * 
 *         Repeatedly swaps the adjacent elements
 *         in the correct order
 *
 */
public class BubbleSort {
	static int a[] = { 1, 5, 4, 2 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortFullyRecursive(a, 0, a.length);
		System.out.println(Arrays.toString(a));
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// using itteration and recurrsion both
	public static void sort(int a[], int size) {
		// two for loops i=0 to n
		// other will go from 0 to n-i+1

		if (size == 1)
			return;

		// inner loop of bubble sort
		for (int j = 0; j < size - 1; j++) {
			if (a[j] > a[j + 1])
				swap(a, j, j + 1);
		}
		// converted outer loop of bubblesort into recurssive call;

		sort(a, size - 1);

	}

	public static void sortFullyRecursive(int a[], int j, int size) {
		// two for loops i=0 to n
		// other will go from i+1 to n

		if (size == 1)
			return;
		;
		if (j == size - 1) {
			// means you have done single pass on the array
			// sortFullyRecursive(a, 0, size - 1);

			sortFullyRecursive(a, 0, size - 1);
			return;
		}

		if (a[j] > a[j + 1])
			swap(a, j, j + 1);
		sortFullyRecursive(a, j + 1, size);
		return;
	}

}
