import java.io.*;

import java.util.*;

public class A_ODD_DIVISORS {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());

			if (n > 0 && (n & (n - 1)) > 0)
				pw.println("yes");
			else
				pw.println("no");
			pw.flush();
		}
		pw.close();
		br.close();

	}
}
