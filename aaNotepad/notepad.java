package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int board[][];
	static int N;
	static int res = 0;

	static void bt(int idx) {
		boolean pass = false;

		if (idx == N) {
			res++;
			return;
		}

		for (int j = 0; j < N; j++) {
			pass = false;

			for (int k = j - 1; k >= 0; k--) {
				if (board[idx][k] == 1) {
					pass = true;
					break;
				}
			}

			if (pass)
				continue;

			for (int k = idx - 1; k >= 0; k--) {
				if (board[k][j] == 1) {
					pass = true;
					break;
				}
			}

			if (pass)
				continue;

			int yt = idx - 1;
			int xt = j - 1;

			while (yt >= 0 && xt >= 0) {
				if (board[yt][xt] == 1) {
					pass = true;
					break;
				}
				yt--;
				xt--;
			}

			if (pass)
				continue;

			yt = idx - 1;
			xt = j + 1;

			while (yt >= 0 && xt < N) {
				if (board[yt][xt] == 1) {
					pass = true;
					break;
				}
				yt--;
				xt++;
			}

			if (pass)
				continue;

			board[idx][j] = 1;
			bt(idx + 1);
			board[idx][j] = 0;

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		bt(0);

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
