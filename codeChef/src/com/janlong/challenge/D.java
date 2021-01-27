package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class D {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

		
			int px[] = new int[4];
			int py[] = new int[4];
			int i = 0;
			if (x == y) {
				x = N;
				y = N;
				pw.println(x + " " + y);
				pw.flush();
				continue;
			} else if (x < y) {

				px[0] = x + (N - y);
				py[0] = N;

				px[1] = N;
				py[1] = (N - y) + x;

				px[2] = y - x;
				py[2] = 0;

				px[3] = 0;
				py[3] = y - x;
			} else {
				px[0] = N;
				py[0] = y + (N - x);

				px[1] = y + (N - x);
				py[1] = N;

				px[2] = 0;
				py[2] = x - y;

				px[3] = x - y;
				py[3] = 0;

			}

			// pw.println(px[(K % 4) == 0 ? 0 : K % 4 - 1] + " " + py[(K % 4) == 0 ? 0 : K %
			// 4 - 1]);
			pw.println(px[(K - 1) % 4] + " " + py[(K - 1) % 4]);
			pw.flush();
		}
		pw.close();
		br.close();

	}

}