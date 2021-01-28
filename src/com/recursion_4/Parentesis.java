package com.recursion_4;

import java.util.*;

public class Parentesis {
	static TreeSet<String> t = new TreeSet<String>(Collections.reverseOrder());

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char ch[] = new char[2 * n];

		printParenthesis(n, 0, 0, 0, ch);
		for (String s : t)
			System.out.println(s);

	}

	public static void printParenthesis(int n, int i, int open, int close, char ch[]) {
		if (i == (2 * n)) {
			// ch[i+1]=0;
			// System.out.println(new String(ch));
			t.add(new String(ch));
			return;
		}

		if (open < n) {
			ch[i] = '(';
			open++;
			printParenthesis(n, i + 1, open+1, close, ch);

		}

		if (close < open) {
			ch[i] = ')';
			//close++;
			printParenthesis(n, i + 1, open, close+1, ch);

		}
		// System.out.println();

		return;
	}

}
