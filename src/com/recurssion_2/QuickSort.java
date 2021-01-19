package com.recurssion_2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rohit Arora
 * 
 *         Quick sort is another very popular sorting algorithm
 *         where time complexity is O(logN) in average case
 *         and O(N^2) in worst case.
 *         Its an in-place algorithm so memory complexity is O(1)
 *         
 *         Added shuffle method for Randomized Quicksort
 */
public class QuickSort {
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String args[]) {
		int arr[] = { 0, 1, 2, 3, 4, 5 }; // { 1, 5, 2, 6, 3, 0 };
		// 0 1 | 2 3 5 6
		shuffle(arr, 0, arr.length-1); // shuffling for randomized quick sort
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * @param a--> original array
	 * @param s--> start index
	 * @param e--> end index
	 *             we get position of a partition element by swapping it to right
	 *             place
	 *             and we check recursively sort swap to the left of the partition
	 *             and right to the partition
	 */
	public static void quickSort(int a[], int s, int e) {
		System.out.println("hi");
		if (s >= e)
			return;
		
		int p = partition(a, s, e);
		quickSort(a, s, p - 1);
		quickSort(a, p + 1, e);

	}

	/**
	 * @param a--> original array
	 * @param s--> start index
	 * @param e--> end index
	 * @return --> return the index of partition
	 * 
	 *         partition index is fetched by placing the pivot element
	 *         at its right place which is achieved by swapping smaller elements of
	 *         pivot
	 *         towards the left and larger toward the right
	 *         example { 1 5 4 2 0}
	 *         ---> 0 | 1 5 4 2
	 *         ---> 0 1 2 | 5 4
	 *         ---> 0 1 2 4 5
	 * 
	 *         another example
	 */
	public static int partition(int a[], int s, int e) {

		int i = s - 1;
		int j = s;

		int pivot = a[e];
		
		for (; j <= e - 1;) {
			if (a[j] <= pivot) {
				// merge the smaller element in region 1;
				i++;
				/*
				 * if (i != j) {
				 * a[i] ^= a[j];
				 * a[j] ^= a[i];
				 * a[i] ^= a[j];
				 * }
				 */

				swap(a, i, j);

			}
			// expand the larger region
			j++;
		}
		// swap the pivot element in the correct index
		/*
		 * if (i + 1 != e) {
		 * a[i + 1] = a[i + 1] ^ a[e];
		 * a[e] = a[i + 1] ^ a[e];
		 * a[i + 1] = a[i + 1] ^ a[e];
		 * }
		 */

		swap(a, i + 1, j);
		return i + 1;
	}

	/**
	 * @param a
	 * @param s
	 * @param e
	 * 
	 * Shuffles the orignal array in a random order 
	 * to insure that the sorting runs for O(n Log n)
	 */
	public static void shuffle(int a[], int s, int e) {

		Random p = new Random();
		for (int i = e; i > 0; i--) {
			int j=p.nextInt(e+1);
			System.out.println(j);
			swap(a, i, j);
		}
	}

}
