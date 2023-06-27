package Simulation;

import java.io.*;

public class Q10811_BASKET_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int bas[] = new int[n];

		for (int i = 0; i < n; i++) {
			bas[i] = i + 1;
		}

		int beg, end, dis;

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			beg = Integer.parseInt(inp[0]);
			end = Integer.parseInt(inp[1]);
			dis = end - beg + 1;

			int temp[] = new int[dis];

			for (int j = 0; j < dis; j++) {
				temp[j] = bas[beg + j - 1];
			}

			for (int j = dis - 1; j >= 0; j--) {
				bas[end - j - 1] = temp[j];
			}

		}

		for (int i = 0; i < n; i++) {
			bw.write(bas[i] + " ");
		}

		bw.flush();
		bw.close();

	}
}