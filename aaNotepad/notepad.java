package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int floor[];

	static void bfs(int F, int S, int U, int D) {

		int res = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(S);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur + U <= F && cur + U > 0 && U != 0) {
				int temp = cur + U;
				if (floor[temp] == 0) {
					floor[temp] = floor[cur] + 1;
					q.add(temp);
				}
			}
			if (cur - D <= F && cur - D > 0 && D != 0) {
				int temp = cur - D;
				if (floor[temp] == 0) {
					floor[temp] = floor[cur] + 1;
					q.add(temp);
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int F, S, G, U, D;

		String inp[] = br.readLine().split(" ");
		F = Integer.parseInt(inp[0]);
		S = Integer.parseInt(inp[1]);
		G = Integer.parseInt(inp[2]);
		U = Integer.parseInt(inp[3]);
		D = Integer.parseInt(inp[4]);
		floor = new int[F + 1];
		Arrays.fill(floor, 0);

		bfs(F, S, U, D);

		if (S == G)
			bw.write("0");
		else if (floor[G] > 0)
			bw.write(floor[G] + "");
		else
			bw.write("use the stairs");
		bw.flush();
		bw.close();

	}

}
