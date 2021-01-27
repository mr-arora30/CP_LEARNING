package com.cf697;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Rohit Arora
 * https://codeforces.com/contest/1475/problem/B
 */
public class B_NEW_YEAR {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int b = n % 2020;
			int a = n / 2020;

			pw.println(b <= a ? "yes" : "no");
			// pw.println();
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
