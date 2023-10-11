package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int n;
	static int pal[];
	static boolean mem[][];
	static boolean visited[][];

	static boolean dp(int s, int e) {

		if (visited[s][e])
			return mem[s][e];
		else {
			mem[s][e] = dp(s + 1, e - 1);
			visited[s][e] = true;
			return mem[s][e];
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		pal = new int[n + 1];
		mem = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		String inp[] = br.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			pal[i] = Integer.parseInt(inp[i - 1]);
		}

		mem[1][1] = true;
		visited[1][1] = true;
		for (int i = 2; i <= n; i++) {
			mem[i][i] = true;
			visited[i][i] = true;
			if (pal[i] == pal[i - 1]) {
				mem[i - 1][i] = true;
				visited[i - 1][i] = true;
			} else {
				mem[i - 1][i] = false;
				visited[i - 1][i] = true;
			}
		}

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			int s = Integer.parseInt(inp[0]);
			int e = Integer.parseInt(inp[1]);
			if (dp(s, e))
				bw.write("1\n");
			else
				bw.write("0\n");
		}

		bw.flush();
		bw.close();

	}
}
