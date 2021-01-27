package com.edu.r101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A_RBS {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			String s = br.readLine();

			int count=0;
			Character q;
			for (int i = 0; i < s.length(); i++) {
				q = s.charAt(i);
				
				if(q=='?') {
					count++;
				}
			}
			if(s.charAt(0)==')') {
				pw.println("NO");
			}else if(s.charAt(s.length()-1)=='(') {
				pw.println("NO");
			}else if(count%2!=0)
				pw.println("NO");
			else
				pw.println("YES");
			
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
