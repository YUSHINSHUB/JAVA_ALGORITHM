package Sorting;

import java.io.*;
import java.util.*;

public class Q25305_Cutline_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		Integer scr[] = new Integer[n];

		inp = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			scr[i] = Integer.parseInt(inp[i]);
		}

		Arrays.sort(scr, Comparator.reverseOrder());

		bw.write(scr[k - 1] + "");

		bw.flush();
		bw.close();

	}
}
