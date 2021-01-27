package com.janlong.challenge;

import java.util.*;
import java.io.*;

public class E {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			LinkedHashSet<Integer> sups = new LinkedHashSet<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			
			int boxes[] = new int[n];
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(boxes);
			sups.add(boxes[n - 1]);
			sum = boxes[n - 1];
			int cnt_boxes = -1;
			for (int i = n - 2; i >= 0; i--) {
				LinkedHashSet<Integer> subset = new LinkedHashSet<Integer>();
				sum = sum + boxes[i];
				Iterator i1 = sups.iterator();
				while (i1.hasNext()) {
					int h = (int) (i1.next());
					subset.add(h);
					subset.add(boxes[i]);
					subset.add(h + boxes[i]);
					if (((h + boxes[i]) >= k) && ((sum - h - boxes[i]) >= k)) {
						cnt_boxes = n - i;
						break;
					}
					if (((boxes[i]) >= k) && ((sum - boxes[i]) >= k)) {
						cnt_boxes = n - i;
						break;
					}
				}
				if (cnt_boxes != -1) {
					break;
				}
				sups = subset;
			}
			pw.println(cnt_boxes);
			pw.flush();
		}
		pw.close();
		br.close();

	}
}