package com.bitwise.practice;

import java.util.Scanner;

public class TavasSadaas {
	
	public static int getIndexOfLuckyNo(long no) {
		String n = no + "";

		int no_of_digits = n.length();
		/*
		 * to get number of numbers for X-1 digits its in the from of GP 2^1
		 * +2^2+2^3...2^X-1 GP = a(1-r^n)/(1-r) = 2(1-2^x-1)/1-2 = 2-2^x/-1 = 2^x-2
		 */

		long total_lucky_nos_uptoXminus1digits = (1l << no_of_digits) - 2;
		long ans = total_lucky_nos_uptoXminus1digits;
		/*
		 * Now its time to calculate the the final part for 
		 * the answer which is for last digit how many 
		 * numbers to be added,
		 * so if its 7 in units digit then it can have 1 more
		 * digit which is 2^0
		 * and if we move to 10s digit then if again
		 * if it has 7 at tens digit then we can have 47 or 44
		 * so 2 possibilites 2^1
		 * like wise it will have all the possibilites
		 */
		for (int i = no_of_digits - 1, pos = 0; i >= 0; i--, pos++) {

			if (n.charAt(i) == '7') {
				ans += (1 << pos);
			}

		}
		/*
		 * as we have calculated only upto x-1 digits 
		 * so add 1 to the number
		 */
		ans++;
		return (int) ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(getIndexOfLuckyNo(sc.nextInt()));

	}

}
