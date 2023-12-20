package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int grid[][];

	static String recur(int idx, int y, int x) {

		String res = "";
		int sym;
		if (grid[y][x] == 0)
			sym = 0;
		else
			sym = 1;

		for (int i = y; i < y + idx; i++) {
			for (int j = x; j < x + idx; j++) {
				if (grid[i][j] != sym) {
					sym = -1;
					break;
				}
			}
			if (sym < 0)
				break;
		}

		if (sym >= 0) {
			res += sym;
		} else {
			idx /= 2;
			res += "(";
			res += recur(idx, y, x);
			res += recur(idx, y, x + idx);
			res += recur(idx, y + idx, x);
			res += recur(idx, y + idx, x + idx);
			res += ")";
		}

		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = inp.charAt(j) - '0';
			}
		}

		bw.write(recur(N, 0, 0));
		bw.flush();
		bw.close();

	}

}
