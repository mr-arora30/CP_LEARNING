package com.recursion_2;

import java.util.Iterator;

/**
 * @author Rohit Arora
 *         This problem is about finding the total count
 *         of pairs such that a[i] > a[i+1 to n]
 * 
 *         This can be easily achieved using two nested loops
 *         for i to n-2{
 *         for j=i+1 to n-1{
 *         if(a[i]>a[j])
 *         count++;
 *         }
 *         }
 *         but the above brute force algo will take O(n^2).
 * 
 *         In the below solution we use divide and conquer to decrease the
 *         complexity to O(log n)
 * 
 */
public class InversionCount {

	public static void main(String args[]) {
		int arr[] = new int[4]; //{ 1, 5, 4, 2 };// { 1, 5, 2, 6, 3, 0 };
		//arr={ 1, 5, 4, 2 };
		arr[0]=1;
		arr[1]=5;
		arr[2]=4;
		arr[3]=2;

		System.out.println(inversion_count(arr, 0, arr.length - 1));
	}

	/**
	 * @param a-->original array
	 * @param s-->         start index
	 * @param e-->         end index
	 * @return --> total number of count of pairs
	 * 
	 *         In this method we basically use merge sort algo with little
	 *         modification
	 *         at merge method where merge method basically returns the count of the
	 *         pairs
	 *         in cross subproblems which is 2 divided arrays parts (z)
	 *         z---> count of pairs in cross subproblems
	 *         y-->>> count of pairs in right subproblems
	 *         x-->>> count of pairs in the left subproblems
	 * 
	 * 
	 */
	public static int inversion_count(int a[], int s, int e) {

		if (s >= e)
			// no inversions
			return 0;
		int mid = (s + e) / 2;
		int x = inversion_count(a, s, mid);
		int y = inversion_count(a, mid + 1, e);
		int z = merge(a, s, e);
		return x + y + z;
	}

	/**
	 * @param a--> original array
	 * @param s--> start index for the subproblem
	 * @param e--> end index for the subproblem
	 * @return--> count of the number of possible pairs for the cross subproblems
	 *            i.e., left and right subproblems.
	 * 
	 *            In this step we use merge sort like approach where
	 *            divided sub problems are sorted and merged.
	 *            and while check if a[i]>a[j]
	 *            we count the number of pairs can be formed from the index i to end
	 *            as its sorted meaning, if element at index i is > than element at
	 *            j
	 *            means i+1 to e elements would also be greater than element and at
	 *            j.
	 *
	 * 
	 */
	public static int merge(int a[], int s, int e) {
		int mid = (s + e) / 2;
		int i = s;
		int j = mid + 1;
		int k = s;
		int temp[] = new int[10000];
		int count = 0;
		while (i <= mid && j <= e) {

			if (a[i] < a[j])
				temp[k++] = a[i++];
			else {
				temp[k++] = a[j++];
				count += mid - i + 1; // mid -(i-1) elements
			}
		}
		while (i <= mid)
			temp[k++] = a[i++];
		while (j <= e)
			temp[k++] = a[j++];

		// System.arraycopy(temp, s, a, s, (e - s) + 1);
		for (int l = s; l <= e; l++) {
			a[l] = temp[l];
		}
		return count;
	}

}
