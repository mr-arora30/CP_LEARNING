package com.goodbye;
import java.util.*;
import java.io.*;

/**
 * @author Rohit Arora
 *https://codeforces.com/contest/1466/problem/C
 */
public class C_Palindrome_Correct {
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			char[] ch = br.readLine().trim().toCharArray();
			int count = 0;
			for (int i = 1; i < ch.length; i++) {
				if (ch[i] == ch[i - 1]) {
					ch[i] = '!';
					count++;
				} else if (i > 1 && ch[i] == ch[i - 2]) {
					ch[i] = '!';
					count++;
				}
			}

			pw.println(count);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
