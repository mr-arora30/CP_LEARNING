package com.bitwise.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Rohit Arora Question Count no of numbers which are present between L
 *         and R (both inclusive) which have exactly one 0 in their binary
 *         reprsentation. Complexity = O(Log 64)
 */
public class CountExact0bits {
	static long count(long L, long R) {

		String last = Long.toBinaryString(R);
		String first = Long.toBinaryString(L);

		int r = last.length();
		int l = first.length();
		// System.out.println("r leng "+ r +"l len "+ l);
		long ans = 0;
		// caculate for lower bound
		int lower_b = Long.bitCount(L);

		long n = L;
		int posL = 0;

		if (lower_b < l) { // for 111 case
			while (n > 0) {
				posL++;
				n = n >> 1;
			}
			ans += (posL - 1);
			if ((L == R) && (ans != 0)) { // for case such as 5 and 5
				if(lower_b!=(l-1)) {
					ans=0;
				}
				else
				ans = 1;
			}
		}

		// calculate uper bound
		/*
		 * if upper bound is found to be max then simply total_bits-1 is the count of
		 * nos present for n of bits of R
		 */
		int upper_b = Long.bitCount(R);
		if (l != r)
			if (upper_b == r) {
				ans += (r - 1);
			} else {
				long n1 = R;
				int posU1 = -1;
				while (n1 > 0) {
					posU1++;
					n1 = n1 >> 1;

				}
				long n2 = R;
				/*
				 * Idea here is to find all the combinations for R(last no) whose 64 bits so we
				 * set all the bits 1 except 1 which is left to 0 from right to left preceeding
				 * from MSB+1 till 0th index of bit and then setting everything to 1 and repeat
				 * the process and count the total no of numbers having exactly 0 in binary rep
				 * which are less than R(lastno).
				 * 
				 */
				for (long i = posU1 - 1; i >= 0; i--) {

					long mask = ~(1l << i);
					// clearing ith bit
					n2 = n2 & mask;
					// setting last i bits
					long mask_set = (1l << i) - 1;
					n2 = n2 | mask_set;
					if (n2 <= R) {
						ans++;
					}
					n2 = n2 | ((1l << (posU1)) - 1l);
				}
			}

		/*
		 * calculate all for middle bits. using N-1 bits total combinations
		 */
		for (long i = l + 1; i < r; i++) { // runs at max 64 times
			ans += (i - 1);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String[] line = br.readLine().split(" ");
		long L = Long.parseLong(line[0]);
		long R = Long.parseLong(line[1]);

		long out_ = count(L, R);
		System.out.println(out_);

		wr.close();
		br.close();

	}

}
