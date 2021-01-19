package com.recursion_3;

import java.io.PrintWriter;

/**
 * @author Rohit Arora
 * 2048 Problem is converting number to their Spellings
 * like 2048 --> Two Zero Four Eight
 * This porblem is solved using recursion pretty easily..
 * 
 * The another problem is to convert number it to words
 * like 20048---> Twenty Thousand Forty Eight
 */
public class P2408 {

	static String spell[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	static String one[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	static String ten[] = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Sventy", "Eighty", "Ninety" };
	// static String sp3[] = { "Lakh", "Thousand", "Hundered" };
	// static String sp4[] = { "", "", "Eleven", "Twelve", "Thirteen", "Sixteen",
	// "Seventeen", "Eighteen", "Nineteen" };

	// 50000 Fifty thousand
	// 5012 Five Thousand Twelve
	public static void main(String[] args) {

		printSpells(1048);
		System.out.println();
		System.out.println(convertToWords(148));
	}

	public static void printSpells(int n) {
		if (n <= 0)
			return;

		printSpells(n / 10); // n/10 fetches last digit

		System.out.print(" " + spell[n % 10]);
	}

	static String convertToWords(long n) {
		// stores word representation of given number n
		String out = "";

		// handles digits at ten millions and hundred
		// millions places (if any)
		out += numToWords((int) (n / 10000000), "crore ");

		// handles digits at hundred thousands and one
		// millions places (if any)
		out += numToWords((int) ((n / 100000) % 100), "lakh ");

		// handles digits at thousands and tens thousands
		// places (if any)
		out += numToWords((int) ((n / 1000) % 100), "thousand ");

		// handles digit at hundreds places (if any)
		out += numToWords((int) ((n / 100) % 10), "hundred ");

		if (n > 100 && n % 100 > 0) {
			out += "and ";
		}

		// handles digits at ones and tens places (if any)
		out += numToWords((int) (n % 100), "");

		return out;
	}

	static String numToWords(int n, String s) {
		String str = "";
		// if n is more than 19, divide it
		if (n > 19) {
			str += ten[n / 10] +" " +one[n % 10];
		} else {
			str += one[n].equals("") ? "":one[n]+" ";
		}
			
		// if n is non-zero
		if (n != 0) {
			str += s;
		}

		return str;
	}
}
