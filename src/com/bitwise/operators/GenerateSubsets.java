package com.bitwise.operators;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Rohit Arora
 *  Question: Generate subsets for a given string.(using bitwise) sample i/p
 *         = abc sample o/p = " ", a , b , c, ab ,ac ,bc, abc
 * 
 *         Additonally sort the output
 *         
 *         Approach: the number of total sets are of 2^size-1 of string
 *         assign each bit to each char of string and 
 *         print based on the number of 1s in bit
 *         example 000 = ""
 *         001=a
 *         010=b
 *         101=ac
 *         ...
 *         
 *         to filter chars you need to extract last bit
 *         if bit is 1 then contatinate to the ans
 *         else loop until that number becomes 0
 *         
 * 
 * 
 *
 */
public class GenerateSubsets {

	public static String filter_chars(String a, int num) {

		int j = 0;
		String ans = "";
		while (num > 0) {
			int last_bit = (num & 1);
			if (last_bit == 1) {
				ans = ans + a.charAt(j);
			}
			j++;
			num = num >> 1;

		}

		return ans;
	}

	public static void print_subsets(String a) {
		int size = a.length();
		Set<String> s = new TreeSet<String>();

		for (int i = 0; i < (1 << size); i++) { // i<2^n

			System.out.println(filter_chars(a, i));

			s.add(filter_chars(a, i));
		}
		System.out.println("........................");
		System.out.println("Sorterd implmentation");
		for (String sa : s) {
			System.out.println(sa);
		}
	}

	public static void main(String[] args) {

		String a = "abcd";

		print_subsets(a);
	}

}
