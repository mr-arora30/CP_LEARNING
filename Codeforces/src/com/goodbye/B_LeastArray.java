package com.goodbye;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class B_LeastArray {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// printing inputs fastest
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			Set<Integer> notes = new HashSet<Integer>();
			st = new StringTokenizer(br.readLine());
			while (N-- > 0) {
				int note = Integer.parseInt(st.nextToken().trim());
				notes.add(notes.contains(note) ? note + 1 : note);

			}

			pw.println(notes.size());
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
