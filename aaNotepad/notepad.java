package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int n;
	static int out = 0;
	static int choice[] = new int[100001];
	static Boolean visited[] = new Boolean[100001];
	static Boolean loop[] = new Boolean[100001];

	static void dfs(int idx) {

		if (visited[idx])
			return;

		visited[idx] = true;

		int nidx = choice[idx];
		
		if(!visited[nidx] ) {
			dfs(nidx);
		}
		if (visited[nidx] && !loop[nidx]) {
			out++;
				for (int i = nidx; i != idx; i = choice[i])
					out++;
		}

		loop[idx] = true;

	}

	static int search() {

		for (int i = 1; i <= n; i++) {
			dfs(i);
		}

		return out;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;

		T = Integer.parseInt(br.readLine());

		for (int cs = 0; cs < T; cs++) {
			n = Integer.parseInt(br.readLine());
			out = 0;
			Arrays.fill(loop, false);
			Arrays.fill(visited, false);
			String inp[] = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				choice[i] = Integer.parseInt(inp[i - 1]);
			}
			bw.write(n - search() + "\n");
		}

		bw.flush();
		bw.close();
	}
}