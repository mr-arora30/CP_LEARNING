package com.goodbye;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Rohit Arora
 * https://codeforces.com/contest/1466/problem/B
 *
 */
public class GOODBYE_B {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int notes[] = new int[(2 * N) + 2];
			st = new StringTokenizer(br.readLine());

			int count = 0;
			int f = N;
			while (f-- > 0) {
				int k = Integer.parseInt(st.nextToken());
				if (notes[k] == 0)
					notes[k] = 1;

				else
					notes[k + 1]++;

			}

			for (int i = 1; i < notes.length; i++) {

				if (notes[i] > 0)
					count++;

			}

			pw.println(count);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}