package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2477_Korean_Melon_Field_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());
		int dir[] = new int[6];
		int len[] = new int[6];
		int lrbeg = 0;
		int udbeg = 0;
		int clk = -1;
		int res = 0;

		for (int i = 0; i < 6; i++) {
			String inp[] = br.readLine().split(" ");
			dir[i] = Integer.parseInt(inp[0]);
			len[i] = Integer.parseInt(inp[1]);
			if (dir[i] == 1 || dir[i] == 2) {
				if (clk == -1)
					clk = dir[i];
				lrbeg += dir[i];
			} else {
				udbeg += dir[i];
			}
		}

		if (lrbeg == 4) {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 2) {

					int u = i + 1;
					int d = i - 1;
					if (u > 5)
						u -= 6;
					if (d < 0)
						d += 6;

					if (udbeg == 11) {
						if (dir[u] == 4) {
							res += len[i] * len[u];
							d = u + 2;
							u += 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						} else {
							res += len[i] * len[d];
							d = i + 2;
							u = i + 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						}
					} else {
						if (dir[u] == 3) {
							res += len[i] * len[u];
							d = u + 2;
							u += 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						} else {
							res += len[i] * len[d];
							d = i + 2;
							u = i + 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						}
					}

				}
			}
		} else {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 1) {

					int u = i + 1;
					int d = i - 1;
					if (u > 5)
						u -= 6;
					if (d < 0)
						d += 6;

					if (udbeg == 11) {
						if (dir[u] == 4) {
							res += len[i] * len[u];
							d = u + 2;
							u += 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						} else {
							res += len[i] * len[d];
							d = i + 2;
							u = i + 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						}
					} else {
						if (dir[u] == 3) {
							res += len[i] * len[u];
							d = u + 2;
							u += 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						} else {
							res += len[i] * len[d];
							d = i + 2;
							u = i + 3;
							if (u > 5)
								u -= 6;
							if (d > 5)
								d -= 6;
							res += len[u] * len[d];
						}
					}

				}
			}
		}

		res *= k;
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}