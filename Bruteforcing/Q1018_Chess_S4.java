package Bruteforcing;

import java.io.*;
import java.math.*;

public class Q1018_Chess_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split(" ");
		int x = Integer.parseInt(nums[1]);
		int y = Integer.parseInt(nums[0]);
		int xgap = x - 8;
		int ygap = y - 8;

		String board[][] = new String[y][x];
		String line[] = new String[x];
		int ra = 0, rb = 0;
		int res = 64;

		for (int i = 0; i < y; i++) {
			line = br.readLine().split("");
			for (int z = 0; z < x; z++) {
				board[i][z] = line[z];
			}
		}
		for (int q = 0; q <= ygap; q++) {
			for (int t = 0; t <= xgap; t++) {
				ra = 0;
				rb = 0;
				for (int i = q; i < 8 + q; i++) {
					if (i % 2 == 0) {
						for (int z = t; z < 8 + t; z += 2) {
							if (!board[i][z].equals("B"))
								ra++;
							else
								rb++;
						}
						for (int z = t + 1; z < 8 + t; z += 2) {
							if (!board[i][z].equals("W"))
								ra++;
							else
								rb++;
						}
					} else {
						for (int z = t; z < 8 + t; z += 2) {
							if (!board[i][z].equals("W"))
								ra++;
							else
								rb++;
						}
						for (int z = t + 1; z < 8 + t; z += 2) {
							if (!board[i][z].equals("B"))
								ra++;
							else
								rb++;
						}
					}
				}
				res = Math.min(res, Math.min(ra, rb));
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}