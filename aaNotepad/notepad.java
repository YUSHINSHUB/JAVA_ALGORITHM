package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int x[] = new int[n];
		int y[] = new int[n];

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			x[i] = Integer.parseInt(inp[0]);
			y[i] = Integer.parseInt(inp[1]);
		}

		int res = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = 0;
				if (x[i] == x[j] && y[i] != y[j]) {
					temp = (int) Math.abs(y[i] - y[j]);
					for (int k = 0; k < n; k++) {
						if (y[i] == y[k] && x[i] != x[k]) {
							temp *= (int) Math.abs(x[i] - x[k]);
							if (temp > res)
								res = temp;
							temp /= (int) Math.abs(x[i] - x[k]);
						}
					}
				}
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
