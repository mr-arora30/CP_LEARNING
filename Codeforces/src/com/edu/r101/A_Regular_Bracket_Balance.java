package com.edu.r101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * @author Rohit Arora
 *https://codeforces.com/contest/1469/problem/A
 */
public class A_Regular_Bracket_Balance {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
		final String YES = "YES";
		final String NO = "NO";
		while (t-- > 0) {

			String s = br.readLine();
			char[] a = s.toCharArray();
			int N = a.length;
			if (N % 2 != 0) {
				pw.println(NO);
				pw.flush();
				continue;
			}
			int half = N / 2 - 1;
			int index = 0;
			for (int i = 0; i < N; i++)
				if (a[i] == '?')
					a[i] = index++ < half ? '(' : ')';

			pw.println(checkLevel(a) ? YES : NO);
			pw.flush();
		}

		pw.close();
		br.close();

	}

	public static boolean checkLevel(char s[]) {
		int level = 0;

		for (char c : s) {
			if (c == '(')
				level++;
			else {
				level--;
				if (level < 0)
					return false;
			}
		}

		return level == 0;
	}
}
