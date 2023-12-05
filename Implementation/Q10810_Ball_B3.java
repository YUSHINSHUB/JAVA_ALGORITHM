package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10810_Ball_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int bas[] = new int[n];
		Arrays.fill(bas, 0);
		int m = Integer.parseInt(inp[1]);
		int i, j, k;

		for (int l = 0; l < m; l++) {
			inp = br.readLine().split(" ");
			i = Integer.parseInt(inp[0]);
			j = Integer.parseInt(inp[1]);
			k = Integer.parseInt(inp[2]);
			for (int o = i - 1; o < j; o++) {
				bas[o] = k;
			}
		}

		for (int l = 0; l < n; l++) {
			bw.write(bas[l] + " ");
		}

		bw.flush();
		bw.close();

	}
}
