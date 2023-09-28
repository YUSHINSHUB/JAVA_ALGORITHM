package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q14889_Start_Link_S2 {

	static int n;
	static int res = Integer.MAX_VALUE;
	static int par[][];
	static boolean visited[];

	static void bt(int idx, int cnt) {
		if (cnt == n / 2) {
			int s = 0, l = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i] && visited[j])
						s += par[j][i];
					else if (!visited[i] && !visited[j])
						l += par[j][i];
				}
			}
			res = Math.min(res, Math.abs(s - l));
		} else {
			for (int i = idx; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					bt(i + 1, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		Arrays.fill(visited, false);
		par = new int[n][n];
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				par[i][j] = Integer.parseInt(inp[j]);
		}

		bt(0, 0);
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}