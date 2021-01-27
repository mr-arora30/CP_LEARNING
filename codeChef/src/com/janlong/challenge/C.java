package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class C {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine().trim());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long JN[] = new long[N];
			long JM[] = new long[M];
			long sumN = 0;
			long sumM = 0;

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {

				JN[i] = Long.parseLong(st.nextToken());

				sumN += JN[i];

			}
			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < M; i++) {

				JM[i] = Long.parseLong(st.nextToken());

				sumM += JM[i];

			}
			Arrays.sort(JM);
			Arrays.sort(JN);

			int swap = 0;

			int i = 0;
			M--;
			while (sumN <= sumM && i < JN.length && M >= 0) {

				sumN -= JN[i];
				sumN += JM[M];
				sumM -= JM[M];
				sumM += JN[i];
				i++;
				M--;
				swap++;

			}
			if (sumN <= sumM)
				swap = -1;

			pw.println(swap);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}