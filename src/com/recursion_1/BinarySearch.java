package com.recursion_1;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(BS(a, 10, 10));
		System.out.println(bsrec(a, 0, 10 - 1,11));
	}

	public static int BS(int a[], int size, int num) {
		int high = size;
		int low = 0;
		int cnt = 0;
		int mid = (high + low) / 2;
		while (true) {
			if (a[mid] == num) {
				System.out.println("count " + cnt);
				return mid;
			}
			if (mid == 0 || mid == size - 1)
				break;
			if (num > a[mid]) {
				low = mid;
				mid = (low + high) / 2;

			} else if (num < a[mid]) {
				high = mid;
				mid = (low + high) / 2;
			}
			cnt++;
		}
		System.out.println("count " + cnt);
		return -1;
	}

	public static int bsrec(int a[], int low, int high, int num) {

		if (low <= high) {
			int mid = (low + high) >> 1;

			if (a[mid] == num)
				return mid;
			else if (a[mid] < num) {

				return bsrec(a, mid + 1, high, num);
			} else if (a[mid] > num) {
				return bsrec(a, low, mid - 1, num);

			}
		}

		return -1;
	}
}
