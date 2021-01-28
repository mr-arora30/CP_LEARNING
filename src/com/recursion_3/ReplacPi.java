package com.recursion_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ReplacPi {

	public static void main(String[] args) throws IOException {
		char c[] = new char[10000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		c = Arrays.copyOf(s.toCharArray(), s.length());
		System.out.println(c.length);
		// replacePI(c, 0);
		System.out.println(new String(replacePI(c, 0)));
	}

	public static char[] replacePI(char[] ch, int i) {

		if (ch[i] == 0 || ch[i + 1] == 0)
			return ch;
		if (ch[i] == 'p' && ch[i + 1] == 'i') {
			int j = i + 2;
			/*
			 * while (ch[j] != 0) {
			 * j++;
			 * }
			 */
			j = ch.length;
			ch = Arrays.copyOf(ch, ch.length + 4);
			while (j-- >= i + 2) {
				ch[j + 2] = ch[j];
			}
			ch[i] = '3';
			ch[i + 1] = '.';
			ch[i + 2] = '1';
			ch[i + 3] = '4';
			ch = replacePI(ch, i + 4);
		} else {
			// go the next position
			ch = replacePI(ch, i + 1);
		}
		return ch;

	}
}
