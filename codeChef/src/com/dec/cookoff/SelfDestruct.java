package com.dec.cookoff;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class SelfDestruct {
	public static void main(String args[]) throws IOException {

		BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine().trim());

		while (t-- > 0) {

			String K = br.readLine().trim();

			BigInteger bg = new BigInteger(K, 2);

			/*
			 * Printing
			 */
			
			int len = K.length();
			int c1 = bg.bitCount();

			int c0 = len - c1;
			if (((len & 1) == 1) || c1==0  || c0==0) {
				pw.println(-1);
			} else {
				

				if (c0 > c1) {
					pw.println((c0 - c1) / 2);
				} else if (c0 < c1) {
					pw.println((c1 - c0) / 2);
				} else {
					pw.println(0);
				}

			}

			pw.flush();
		}
		pw.close();
		br.close();
		bin.close();

	}
}
