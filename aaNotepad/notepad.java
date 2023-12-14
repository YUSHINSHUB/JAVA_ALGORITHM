package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static ArrayList<Integer> peo[];
	static Boolean mem[];
	static Boolean res = false;

	static void dfs(int cur, int idx) {

		if (idx == 5) {
			res = true;
			return;
		}

		for (int i = 0; i < peo[cur].size(); i++) {
			if (mem[peo[cur].get(i)]) {
				mem[peo[cur].get(i)] = false;
				dfs(peo[cur].get(i), idx + 1);
				mem[peo[cur].get(i)] = true;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M;
		int a, b;

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		peo = new ArrayList[N];
		mem = new Boolean[N];

		for (int i = 0; i < N; i++)
			peo[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			peo[a].add(b);
			peo[b].add(a);
		}
		Arrays.fill(mem, true);

		for (int i = 0; i < N; i++) {
			mem[i] = false;
			dfs(i, 1);
			mem[i] = true;
			if (res)
				break;
		}

		if (res)
			bw.write("1");
		else
			bw.write("0");
		bw.flush();
		bw.close();

	}

}
