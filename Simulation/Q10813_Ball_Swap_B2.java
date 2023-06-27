package Simulation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10813_Ball_Swap_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int ball[] = new int[n];

		for (int i = 0; i < n; i++) {
			ball[i] = i + 1;
		}

		int a, b;
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);

			int temp = ball[a - 1];
			ball[a - 1] = ball[b - 1];
			ball[b - 1] = temp;
		}

		for (int i = 0; i < n; i++)
			bw.write(ball[i] + " ");

		bw.flush();
		bw.close();

	}
}