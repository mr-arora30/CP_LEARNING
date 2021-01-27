import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Pair {
	int a, b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		PrintWriter pw = new PrintWriter(System.out);
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			ArrayList<Pair> intervals = new ArrayList<Pair>(n);
			String startStr, endStr;
			String currLine ;
			for (int i = 0; i < n; i++) {
				currLine = br.readLine().trim();
				startStr = currLine.split(" ")[1];
				endStr = currLine.split(" ")[2];
				intervals.add(new Pair(
						Integer.parseInt(startStr.split(":")[0]) * 60 + Integer.parseInt(startStr.split(":")[1]),
						Integer.parseInt(endStr.split(":")[0]) * 60 + Integer.parseInt(endStr.split(":")[1])));
			}
			Collections.sort(intervals, new Comparator<Pair>() {
				public int compare(Pair x, Pair y) {
					return x.b - y.b;
				}
			});

			if (n == 1) {
				pw.println(1);
				pw.flush();
				continue;
			}
			int count = 1;
			Pair prev = intervals.get(0);
			for (int i = 1; i < n; i++) {
				Pair cur = intervals.get(i);
				if (prev.b <= cur.a) {
					count++;
					prev = cur;
				}
			}
			pw.println(count);
			pw.flush();
		}
		pw.close();
		br.close();
	}
}