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
		int res = 0;
		int ypos = 0, xpos = 0;
		int grp[][] = new int[n][m];
		int ver6[][] = new int[3][2];
		int hor6[][] = new int[2][3];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i >= 3) {
					res = Math.max(res, grp[i][j] + grp[i - 1][j] + grp[i - 2][j] + grp[i - 3][j]);
				}

				if (j >= 3) {
					res = Math.max(res, grp[i][j] + grp[i][j - 1] + grp[i][j - 2] + grp[i][j - 3]);
				}

				if (i >= 1 && j >= 1) {
					res = Math.max(res, grp[i][j] + grp[i - 1][j] + grp[i][j - 1] + grp[i - 1][j - 1]);
				}

				if (i >= 2 && j >= 1) {
					int ver = 0;
					for (int k = i; k >= i - 2; k--) {
						for (int l = j; l >= j - 1; l--) {
							ver += grp[k][l];
							ver6[i - k][j - l] = grp[k][l];
						}
					}

					res = Math.max(res, ver - ver6[0][1] - ver6[1][1]);
					res = Math.max(res, ver - ver6[1][1] - ver6[2][1]);
					res = Math.max(res, ver - ver6[0][0] - ver6[1][0]);
					res = Math.max(res, ver - ver6[1][0] - ver6[2][0]);

					res = Math.max(res, ver - ver6[0][0] - ver6[2][1]);
					res = Math.max(res, ver - ver6[2][0] - ver6[0][1]);

					res = Math.max(res, ver - ver6[0][0] - ver6[2][0]);
					res = Math.max(res, ver - ver6[0][1] - ver6[2][1]);

				}

				if (j >= 2 && i >= 1) {
					int hor = 0;
					for (int k = i; k >= i - 1; k--) {
						for (int l = j; l >= j - 2; l--) {
							hor += grp[k][l];
							hor6[i - k][j - l] = grp[k][l];
						}
					}

					res = Math.max(res, hor - hor6[1][0] - hor6[1][1]);
					res = Math.max(res, hor - hor6[1][1] - hor6[1][2]);
					res = Math.max(res, hor - hor6[0][0] - hor6[0][1]);
					res = Math.max(res, hor - hor6[0][1] - hor6[0][2]);

					res = Math.max(res, hor - hor6[0][0] - hor6[1][2]);
					res = Math.max(res, hor - hor6[0][2] - hor6[1][0]);

					res = Math.max(res, hor - hor6[0][0] - hor6[0][2]);
					res = Math.max(res, hor - hor6[1][0] - hor6[1][2]);

				}

			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
