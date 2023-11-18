package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int D[];
	static int visited[];
	static Queue<Integer>[] grp = new Queue[1001];

	static int dp(int idx) {
		if (visited[idx] >= 0) {
			return visited[idx];
		}

		while (!grp[idx].isEmpty()) {
			visited[idx] = Math.max(dp(grp[idx].poll()) + D[idx], visited[idx]);
		}

		if (visited[idx] < 0)
			visited[idx] = D[idx];

		return visited[idx];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int cs = 0; cs < T; cs++) {
			String inp[] = br.readLine().split(" ");
			int N = Integer.parseInt(inp[0]);
			D = new int[N + 1];
			visited = new int[N + 1];
			Arrays.fill(visited, -1);
			int K = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(inp[i - 1]);
				grp[i] = new LinkedList<>();
			}
			for (int i = 0; i < K; i++) {
				inp = br.readLine().split(" ");
				grp[Integer.parseInt(inp[1])].add(Integer.parseInt(inp[0]));
			}

			int W = Integer.parseInt(br.readLine());
			bw.write(dp(W) + "\n");
		}
		bw.flush();
		bw.close();

	}

}
