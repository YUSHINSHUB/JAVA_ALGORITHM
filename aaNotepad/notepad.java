package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static boolean visited[] = new boolean[101];
	static long pad[] = new long[101];

	static long dp(int n) {
		if (visited[n] == true) {
			return pad[n];
		} else {
			pad[n] = dp(n - 2) + dp(n - 3);
			visited[n] = true;
			return pad[n];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, false);
		int t = Integer.parseInt(br.readLine());

		pad[1] = 1;
		pad[2] = 1;
		pad[3] = 1;
		visited[1] = true;
		visited[2] = true;
		visited[3] = true;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp(n) + "\n");
		}

		bw.flush();
		bw.close();

	}
}