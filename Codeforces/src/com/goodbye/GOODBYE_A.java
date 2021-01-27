package com.goodbye;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Rohit Arora
 *https://codeforces.com/contest/1466/problem/A
 */
public class GOODBYE_A {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			Set<Double> hashSet = new HashSet<Double>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int trees[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = N - 1; i > 0; i--) {

				for (int j = i - 1; j >= 0; j--) {
					hashSet.add((double) (trees[i] - trees[j]) / 2);
				}

			}

			pw.println(hashSet.size());
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
