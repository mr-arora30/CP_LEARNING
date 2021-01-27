package com.cf694;
import java.io.*;

import java.util.*;

/**
 * @author Rohit Arora
 *https://codeforces.com/contest/1471/problem/A
 */
public class A {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int a[] = new int[n];
			int b[] = new int[n];

			// List<Integer> b = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			// a[0] = Integer.parseInt(st.nextToken());
			int min = 0;
			int max = 0;
			// max = (int) Math.ceil((double) (a[0]) / x);
			// min = a[0] % x == 0 ? (int) Math.ceil((double) (a[0]) / x) : 0;
			// a[0]=1;
			for (int i = 0; i < n; i++) {

				a[i] = Integer.parseInt(st.nextToken());
				max = max + (int) Math.ceil((double) (a[i]) / x);
			}
			/*
			 * for (int i = 1; i < a.length - 1; i++) {
			 * if ((a[i] % x != 0)) {
			 * if (a[i - 1] % x != 0)
			 * min = (int) (min + Math.ceil((double) (a[i] + a[i - 1]) / x));
			 * else if (a[i + 1] % x != 0)
			 * min = (int) (min + Math.ceil((double) (a[i] + a[i + 1]) / x));
			 * else
			 * min = min + (int) (Math.ceil((double) (a[i]) / x));
			 * } else {
			 * min = min + (int) (Math.ceil((double) (a[i]) / x));
			 * 
			 * }
			 * max = max + (int) Math.ceil((double) (a[i]) / x);
			 * }
			 */
			boolean prev = false;
			int val = 0;
			// Arrays.sort(a);
			int k = 0;
			for (int i = 0; i < a.length; i++) {

				if (i != a.length - 1) {
					if (a[i] % x != 0 && a[i + 1] % x != 0 && a[i - 1] > a[i + 1]) {
						b[k] = a[i] + a[i + 1];
						k++;
						i++;
					} else {
						b[k] = a[i];
						k++;
						i++;
					}
				} else {
					b[k] = a[i];
					k++;
					i++;
				}

			}
			for (int i = 0; i < b.length; i++) {
				min = min + (int) Math.ceil((double) (a[i]) / x);
			}
			pw.println(min + " " + max);
			pw.flush();
		}
		pw.close();
		br.close();
	}
}
