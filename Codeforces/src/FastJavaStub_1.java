import java.util.*;
import java.io.*;

public class FastJavaStub_1 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			pw.println();
			pw.flush();
		}
		pw.close();
		br.close();

	}
}