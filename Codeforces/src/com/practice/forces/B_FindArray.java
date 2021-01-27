package com.practice.forces;
import java.util.*;
import java.io.*;

public class B_FindArray {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // printing inputs fastest
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        PrintWriter pw = new PrintWriter(ow);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n + 1];
            long evenIndexSum = 0, oddIndexSum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {

                a[j] = Integer.parseInt(st.nextToken());

                if ((j & 1) == 1)
                    oddIndexSum = a[j] + oddIndexSum;
                else
                    evenIndexSum = a[j] + evenIndexSum;

            }

            int b[] = new int[n + 1];
            if (oddIndexSum > evenIndexSum) {
                for (int i = 1; i <= n; i++) {
                    if ((i & 1) == 1)
                        b[i] = a[i];
                    else
                        b[i] = 1;

                }

            } else {
                for (int i = 1; i <= n; i++) {
                    if ((i & 1) == 0)
                        b[i] = a[i];
                    else
                        b[i] = 1;

                }
            }

            /*
             * Printing
             */

            for (int i = 1; i <= n; i++) {

                pw.print(b[i]+ " ");

            }
            pw.println();
            pw.flush();
        }
        pw.close();
        br.close();
        ow.close();

    }

}