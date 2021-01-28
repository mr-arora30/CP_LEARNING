package com.recursion_4;

import java.util.Arrays;

public class GeneratingSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch[] = "abc".toCharArray();
		char out[] = new char[ch.length + 1];
		generate(ch, out, 0, 0);
	}

	/**
	 * @param s
	 * 
	 *          abc
	 *          a(n-1) +(n-20
	 */
	public static void generate(char[] s, char[] out, int i, int j) {
		if (i == s.length) {
			out[j] = 0;
			System.out.println(Arrays.toString(out));
			return;
		}
		// include the char
		out[j] = s[i];
		generate(s, out, i + 1, j + 1);

		// exclude the char
		generate(s, out, i + 1, j);

	}

}
