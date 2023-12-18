package Greedy;

import java.io.*;
import java.util.*;

public class Q11399_ATM_S4 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int times[] = new int[n];
		int sum = 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(inp[i]);
		}

		Arrays.sort(times);

		for (int i = 0; i < n; i++) {
			sum += times[i];
			res += sum;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}