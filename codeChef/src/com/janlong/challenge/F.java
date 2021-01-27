package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class F {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			long n = Long.parseLong(br.readLine());
			long cnt = 0;
			long col = 0;
			while (n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long m = Long.parseLong(st.nextToken());
				long[] dist = new long[(int) m];
				for (int i = 0; i < m; i++) {
					dist[i] = Long.parseLong(st.nextToken());
					if (dist[i] > 0) {
						cnt++;
					} else {
						col++;
					}
				}
			}

			pw.println(cnt * col);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}