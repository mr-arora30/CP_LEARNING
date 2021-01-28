package com.dec.cookoff;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class CatchTheif {

	public static void main(String[] args) throws IOException {
		
		BufferedInputStream bin = new BufferedInputStream(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(bin, StandardCharsets.UTF_8));

		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			int p = Integer.parseInt(st.nextToken());
			int th = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(((Math.abs(p-th))%(2*k)) == 0){
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		br.close();
		bin.close();

	}

}
