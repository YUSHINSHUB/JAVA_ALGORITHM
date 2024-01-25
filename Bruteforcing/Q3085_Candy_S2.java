package Bruteforcing;

import java.io.*;
import java.util.*;

public class Q3085_Candy_S2 {

	public char bo[][];

	Q3085_Candy_S2(char bo[][]) {
		this.bo = bo;
	}

	static void swap(Q3085_Candy_S2 at, int a, int b) {
		char temp = at.bo[a][b];
		at.bo[a][b] = at.bo[a][b + 1];
		at.bo[a][b + 1] = temp;
		;
	}

	static void swapy(Q3085_Candy_S2 at, int a, int b) {
		char temp = at.bo[a][b];
		at.bo[a][b] = at.bo[a + 1][b];
		at.bo[a + 1][b] = temp;
	}

	static int chk(Q3085_Candy_S2 a, int n, int max) {

		int cnt = 1;

		for (int i = 0; i < n; i++) {
			for (int z = 1; z < n; z++) {
				if (a.bo[i][z] == a.bo[i][z - 1]) {
					cnt++;
					max = Math.max(cnt, max);
				} else {
					cnt = 1;
				}
			}
			cnt = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int z = 1; z < n; z++) {
				if (a.bo[z][i] == a.bo[z - 1][i]) {
					cnt++;
					max = Math.max(cnt, max);
				} else {
					cnt = 1;
				}
			}
			cnt = 1;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int max = 1;
		char tbo[][] = new char[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int z = 0; z < n; z++) {
				tbo[i][z] = temp.charAt(z);
			}
		}

		Q3085_Candy_S2 a = new Q3085_Candy_S2(tbo);

		max = chk(a, n, max);

		for (int i = 0; i < n; i++) {
			for (int z = 0; z < n - 1; z++) {
				if (a.bo[i][z] != a.bo[i][z + 1]) {
					swap(a, i, z);
					max = chk(a, n, max);
					swap(a, i, z);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int z = 0; z < n - 1; z++) {
				if (a.bo[z][i] != a.bo[z + 1][i]) {
					swapy(a, z, i);
					max = chk(a, n, max);
					swapy(a, z, i);
				}
			}
		}

		bw.write(String.valueOf(max));

		bw.flush();
		bw.close();

	}
}
