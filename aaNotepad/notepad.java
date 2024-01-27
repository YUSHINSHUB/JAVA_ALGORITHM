package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int mem[] = new int[110000];
	static ArrayList<Integer> list = new ArrayList<>();

	static void bfs(int N, int K) {

		Arrays.fill(mem, -1);
		mem[N] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while (!q.isEmpty()) {
			int cur = q.poll();
			int next = cur + 1;
			if (next < 110000 && next >= 0) {
				if (mem[next] < 0) {
					q.add(next);
					mem[next] = mem[cur] + 1;
				}
			}
			next = cur - 1;
			if (next < 110000 && next >= 0) {
				if (mem[next] < 0) {
					q.add(next);
					mem[next] = mem[cur] + 1;
				}
			}
			next = cur * 2;
			if (next < 110000 && next >= 0) {
				if (mem[next] < 0) {
					q.add(next);
					mem[next] = mem[cur] + 1;
				}
			}
		}

	}

	static void find(int cur) {

		list.add(cur);

		if (mem[cur] == 0)
			return;

		int next = cur + 1;

		if (next < 110000 && next >= 0) {
			if (mem[next] == mem[cur] - 1) {
				find(next);
				return;
			}
		}

		next = cur - 1;

		if (next < 110000 && next >= 0) {
			if (mem[next] == mem[cur] - 1) {
				find(next);
				return;
			}
		}

		next = cur / 2;

		if (next < 110000 && next >= 0) {
			if (mem[next] == mem[cur] - 1) {
				find(next);
				return;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, K;
		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);

		bfs(N, K);
		find(K);

		bw.write(mem[K] + "\n");
		for (int i = mem[K]; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.flush();
		bw.close();
	}
}