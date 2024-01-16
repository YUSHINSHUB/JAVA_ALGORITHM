package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static char c[][];
	static int N;

	static void recur(int y, int x, int idx) {
		if (idx == 3) {
			c[y][x] = '*';
			c[y + 1][x - 1] = '*';
			c[y + 1][x + 1] = '*';
			c[y + 2][x - 2] = '*';
			c[y + 2][x - 1] = '*';
			c[y + 2][x] = '*';
			c[y + 2][x + 1] = '*';
			c[y + 2][x + 2] = '*';
		} else {
			int nx = idx / 2;
			recur(y, x, nx);
			recur(y + nx, x - nx, nx);
			recur(y + nx, x + nx, nx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder("");
		
		N = Integer.parseInt(br.readLine());
		c = new char[N][N * 2];
		
		for( int i = 0 ; i < N ; i++ ) Arrays.fill(c[i], ' ');
		
		recur(0, N - 1, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2; j++)
				sb.append(c[i][j]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}