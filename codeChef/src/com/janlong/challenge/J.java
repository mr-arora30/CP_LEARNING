package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class J {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			TreeSet<Integer> h11 = new TreeSet<Integer>();

			Stack<Integer> s11 = new Stack<Integer>();
			h11.add(0);
			s11.push(0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int a1[] = new int[n];
			int b1[] = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b1[i] = Integer.parseInt(st.nextToken());
			}
			while (!s11.isEmpty()) {
				int x = (int) (s11.pop());
				for (int i = 0; i < n; i++) {
					int y = a1[i];
					if (!h11.contains(x | y)) {
						h11.add(x | y);
						s11.push(x | y);
					}
				}
				for (int i = 0; i < m; i++) {
					int y = b1[i];
					if (!h11.contains(x & y)) {
						h11.add(x & y);
						s11.push(x & y);
					}
				}
			}

			pw.println(h11.size());
			pw.flush();
		}
		pw.close();
		br.close();

	}
}