package com.dec.cookoff;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
public class Attendence{

    public static void main(String args[]) throws IOException {

    	BufferedInputStream bin = new BufferedInputStream(System.in); // taking inputs in fast

		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out); 

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String K = br.readLine().trim();

			BigInteger bk = new BigInteger(K,2);
			/*
			 * Printing
			 */
			//System.out.println(bk);
			
			long present = bk.bitCount();

			long absent =N-present;

			double p =(double) absent/120;
			//System.out.println(p);

			if(p>0.25)
			pw.println("NO");
		else
		pw.println("YES");


			pw.flush();
		}
		pw.close();
		br.close();
		bin.close();
		

    }
}