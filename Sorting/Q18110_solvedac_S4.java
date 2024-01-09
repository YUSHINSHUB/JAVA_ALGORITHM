package Sorting;

import java.io.*;
import java.util.*;

public class Q18110_solvedac_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int diff[] = new int[n];
		int start, end;
		int del = (int) (((double) n * 0.15) + 0.5);
		start = del;
		end = n - del;
		int sum = 0;

		for (int i = 0; i < n; i++)
			diff[i] = Integer.parseInt(br.readLine());

		Arrays.sort(diff);

		for (int i = start; i < end; i++)
			sum += diff[i];

		bw.write((int) (((double) sum / (n - (del * 2))) + 0.5) + "");

		bw.flush();
		bw.close();

	}
}