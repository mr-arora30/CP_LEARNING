package com.chef.decLong;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PosPrefix {

    public static void main(String args[]) throws IOException {


        BufferedInputStream br = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(br, StandardCharsets.UTF_8));
        PrintWriter writer = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());
        while(t-->0){
        StringTokenizer sc = new StringTokenizer(r.readLine());
        	int N = Integer.parseInt(sc.nextToken());
        	int K = Integer.parseInt(sc.nextToken());
        	int ans[] = new int[N+1];
        	for (int i=1;i<=N;i++)
        	{	
        		if((i&1)==1){

        			ans[i]=-i;
        		}
        		else
        			ans[i]=i;
        	}
        	//total no of +ve values can be
        		int posVals= N/2;


        		if(posVals<K){
        			int diff= K-posVals;
        			for(int i=N;i>=1; i--){
        				if(diff==0)
        					break;
        				if(ans[i]<0){
        					ans[i]=(ans[i]*(-1));
        					diff--;
        				}
        			}
        		} else if(posVals>K){
        			int diff= posVals-K;
        			for(int i=N;i>=1; i--){
        				if(diff==0)
        					break;
        				if(ans[i]>0){
        					ans[i]=(ans[i]*(-1));
        					diff--;
        				}
        			}
        		}

        		for(int i=1;i<=N;i++)
        			writer.print(ans[i]+" ");

        		writer.println();
        		writer.flush();

        }
       

        br.close();
        r.close();
     
        writer.close();
    }
}