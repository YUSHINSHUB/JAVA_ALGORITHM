package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int V, E;
	static Queue<Integer>[] q = new LinkedList[20001];
	static int chk[] = new int[20001];

	static boolean bfs() {
		boolean res = true;
		int idx = 0;
		Queue<Integer> bq = new LinkedList<>();
		for (int i = 1; i <= V; i++) {
			if (chk[i] == 0) {
				idx = 1;
				chk[i] = 1;
				bq.add(i);
				while (!bq.isEmpty()) {
					int temp = bq.poll();
					while (!q[temp].isEmpty()) {
						int t = q[temp].poll();

						if (chk[t] == 0) {
							if (idx == 1) {
								chk[t] = 2;
								bq.add(t);
							} else {
								bq.add(t);
								chk[t] = 1;
							}
						} else if ((idx == 1 && chk[t] == 1) || (idx == 2 && chk[t] == 2)) {
							res = false;
							break;
						}
					}

					if (!res)
						break;

					if (idx == 1)
						idx = 2;
					else
						idx = 1;
				}
				if (!res)
					break;
				idx = 0;
			}
		}
		return res;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			String inp[] = br.readLine().split(" ");
			V = Integer.parseInt(inp[0]);
			E = Integer.parseInt(inp[1]);
			Arrays.fill(chk, 0);

			for (int j = 1; j <= V; j++)
				q[j] = new LinkedList<>();

			for (int j = 0; j < E; j++) {
				inp = br.readLine().split(" ");
				int a = Integer.parseInt(inp[0]);
				int b = Integer.parseInt(inp[1]);

				q[a].add(b);
				q[b].add(a);
			}

			if (bfs()) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();

	}

}
