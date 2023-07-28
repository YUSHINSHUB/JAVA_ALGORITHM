package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int ps[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++)
				ps[i][j] = Integer.parseInt(inp[j - 1]);
		}

		for (int i = 0; i <= n; i++) {
			ps[0][i] = 0;
			ps[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
			}
		}

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int x2 = Integer.parseInt(inp[2]);
			int y2 = Integer.parseInt(inp[3]);

			int res = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}