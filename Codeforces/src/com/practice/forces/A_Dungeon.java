package com.practice.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Dungeon {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		
		PrintWriter pw = new PrintWriter(System.out);
		while(t-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			long total_shots = (a+b+c);
			//now lets see maximum enanched shots we can get
			
			//long enhanced_shots = (total_shots/7);
			// total 9 hits at every 7th shots
			//long remaining_shots =total_shots-enhanced_shots;
			
			if((total_shots%9)!=0 ){
				
				pw.println("NO");
				continue;
			}
				
			long rounds = total_shots/9;
			
			if(a<rounds || b < rounds || c<rounds )
				pw.println("NO");
			else
				pw.println("Yes");
		}
		pw.close();
		br.close();
	}

}
