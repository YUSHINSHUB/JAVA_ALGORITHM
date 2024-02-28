package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int res = 0;
		int grid[][] = new int[500][500];
		int H, W;

		inp = br.readLine().split(" ");
		H = Integer.parseInt(inp[0]);
		W = Integer.parseInt(inp[1]);

		for (int i = 0; i < H; i++)
			Arrays.fill(grid[i], 0);

		inp = br.readLine().split(" ");
		for (int i = 0; i < W; i++) {
			int cur = Integer.parseInt(inp[i]);
			for (int j = 0; j < cur; j++) {
				grid[j][i] = 1;
			}
		}

		for (int i = 0; i < H; i++) {
			int idx = 0;
			while (grid[i][idx] == 0) {
				idx++;
				if (idx == W)
					break;
			}
			int temp = 0;
			for (int j = idx + 1; j < W; j++) {
				if (grid[i][j] == 0)
					temp++;
				if (grid[i][j] == 1) {
					res += temp;
					temp = 0;
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}