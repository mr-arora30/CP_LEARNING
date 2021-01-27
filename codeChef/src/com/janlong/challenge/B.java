package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class B {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
		String a = "abcdefghijklmnop";
		char letters[] = a.toCharArray();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String encoded = br.readLine().trim();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i = i + 4) {

				sb.append(letters[Integer.parseInt(encoded.substring(i, i + 4), 2)]);

			}

			pw.println(sb.toString());
			pw.flush();
		}
		pw.close();
		br.close();

	}
}