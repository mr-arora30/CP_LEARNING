package com.recursion_2;

import java.util.Arrays;

public class MergeSort {
	static int a[] = { 1, 5, 4, 2 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(int a[], int s, int e) {

		if (s == e)
			return;

		int mid = (s + e) >> 1;
		mergeSort(a, s, mid);
		mergeSort(a,  mid + 1, e);
		merge(a, s, e);

	}

	public static void merge(int a[], int s, int e) {

		int mid = (s + e) >> 1;
		int i = s;
		int j = mid + 1;
		int k = s;

		int temp[] = new int[1000];

		while (i <= mid && j <= e) {
			if (a[i] < a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		while (i <= mid)
			temp[k++] = a[i++];
		while (j <= e)
			temp[k++] = a[j++];

		// copy all the elements to original array.
		System.arraycopy(temp, s, a, s, (e - s) + 1);

		/*
		 * for (i = s; i <= e; i++)
		 * a[i] = temp[i];
		 */
		
		}
	
}
