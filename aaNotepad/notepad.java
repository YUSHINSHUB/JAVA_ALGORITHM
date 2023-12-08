package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		int a, b;
		int res[];
		ArrayList<Integer> list[];
		Queue<Integer> q = new LinkedList<>();

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		res = new int[N + 1];
		Arrays.fill(res, 0);
		q.add(1);

		for (int i = 0; i < N - 1; i++) {
			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			list[a].add(b);
			list[b].add(a);
		}

		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 0; i < list[idx].size(); i++) {
				if (res[list[idx].get(i)] == 0) {
					res[list[idx].get(i)] = idx;
					q.add(list[idx].get(i));
				}
			}
		}

		for (int i = 2; i <= N; i++)
			bw.write(res[i] + "\n");

		bw.flush();
		bw.close();

	}

}
