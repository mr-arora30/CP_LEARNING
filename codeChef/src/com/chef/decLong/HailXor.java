package com.chef.decLong;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HailXor {

	public static void main(String args[]) throws IOException {

		BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			long arr[] = new long[N + 1];
			int k = 1;

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {

				arr[k] = Integer.parseInt(st.nextToken());
				k++;

			}
			int i = 0;
			int j = 2;
			int loop = 0;
			if (X > N) {
				loop = N;
			} else {
				loop = X;
			}
		//	if(N>2) {
			while (loop-- > 0) {

				for (int z = i; z <= N; z++) {
					if (arr[z] != 0) {
						i = z;
						break;
					}
				}
				if (i == j)
					break;

				long p = (int) ((Math.log(arr[i])) / (Math.log(2)));
				//p = p - 1;
				long xor = 1 << p;
				arr[i] = arr[i] ^ xor;
				arr[j] = arr[j] ^ xor;

				if (j < N) {
					j++;
				} else if (i < (N - 1)) {
					j = i + 1;
				}

			}
			/*}else {
				i=1;j=2;
				int p = (int)((Math.log(arr[i]))/(Math.log(2)));
				
				int xor=1<<p;
		
				
				arr[i]=(arr[i] ^ xor);
				arr[j]=(arr[j] ^ xor);
				if((X&1)!=1){		
					xor=1;
					arr[i]=(arr[i] ^ xor);
					arr[j]=(arr[j] ^ xor);
				}
			}*/

			for (int m = 1; m <= N; m++)
				pw.print(arr[m] + " ");

			pw.println();
			pw.flush();

		}
		pw.close();
		br.close();
		bin.close();

	}
}