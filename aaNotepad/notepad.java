package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer> list[];
	static int mem[];
	static int a, b;
	static int N, M;

	static int bfs() {

		q.add(a);

		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 0; i < list[idx].size(); i++) {
				int temp = list[idx].get(i);
				if (mem[temp] < 0) {
					mem[temp] = mem[idx] + 1;
					q.add(temp);
				}
			}

		}

		return mem[b];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		list = new ArrayList[N + 1];
		mem = new int[N + 1];
		Arrays.fill(mem, -1);
		mem[a] = 0;
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			list[Integer.parseInt(inp[0])].add(Integer.parseInt(inp[1]));
			list[Integer.parseInt(inp[1])].add(Integer.parseInt(inp[0]));
		}

		bw.write(bfs() + "");
		bw.flush();
		bw.close();

	}

}
