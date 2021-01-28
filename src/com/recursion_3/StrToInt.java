package com.recursion_3;

public class StrToInt {
	static int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {
		char c[] = "123".toCharArray();
		System.out.println(StringToInt(c, c.length));
//10
	}

	public static int StringToInt(char[] str, int size) {

		if (size == 0)
			return 0;
		int digit = str[size - 1] - '0';

		int small_ans = StringToInt(str, --size);

		return small_ans * 10 + digit;

		// Another approach by me
		/*
		 * if (size == 0) {
		 * return 0;
		 * }
		 * int number = StringToInt(str, --size) * 10;
		 * 
		 * number += Character.digit(str[size], 10);
		 * return number;
		 */
	}

}
