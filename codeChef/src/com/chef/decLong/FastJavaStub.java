package com.chef.decLong;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FastJavaStub {

	public static void main(String args[]) throws IOException {

		BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		PrintWriter writer = new PrintWriter(System.out); // printing inputs fastest
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			/*
			 * Printing
			 */

			writer.print(" fast");

			writer.println();
			writer.flush();
			
		}

		br.close();
		bin.close();
		writer.close();
		
	}
}
