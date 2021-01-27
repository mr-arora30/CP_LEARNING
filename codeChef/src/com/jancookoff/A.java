package com.jancookoff;

import java.util.*;
import java.io.*;

public class A {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		boolean isprime[] = new boolean[1000000 + 1];

		Arrays.fill(isprime, true);
		isprime[0] = isprime[1] = false;

		for (int i = 2; i <= 1000000; i++) {

			if (isprime[i] && (long) i * i <= 1000000) {
				for (int j = i * i; j <= 1000000; j += i) {
					isprime[j] = false;
				}
			}
		}

		int count[] = new int[1000000 + 1];
		for (int i = 5; i <= 1000000; i++) {
			if (isprime[i] && isprime[i - 2]) {

				count[i] = count[i - 1] + 1;
			} else
				count[i] = count[i - 1];
		}

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			pw.println(count[N]);
			pw.flush();
		}
		pw.close();
		br.close();
	}
}