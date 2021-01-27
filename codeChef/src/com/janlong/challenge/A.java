package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class A {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int a[] = new int[N];
			st = new StringTokenizer(br.readLine());
			long prob = 0;

			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				prob += a[i];

			}
			long ans = (prob / K > D ? D : prob / K);
			pw.println(ans);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}