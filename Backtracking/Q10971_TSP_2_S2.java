package Backtracking;

import java.io.*;
import java.util.*;

public class Q10971_TSP_2_S2 {

	static int n;
	static int res = Integer.MAX_VALUE;
	static int tsp[][];
	static boolean visited[];

	static void bt(int cnt, int sum, int st, int bef) {
		if (cnt == n) {
			if (tsp[bef][st] == 0)
				return;
			else {
				sum += tsp[bef][st];
				res = Math.min(res, sum);
			}
		} else {
			for (int i = 0; i < n; i++) {
				// 해당 문제는 선택한 인덱스들의 순서가 바뀌면 결과도 바뀌기 때문에 모든 경우를 확인하기 위해
				// i를 0부터 시작한다.
				if (!visited[i]) {
					int temp = st;
					if (temp < 0)
						temp = i;
					else if (tsp[bef][i] == 0)
						continue;
					else
						sum += tsp[bef][i];
					visited[i] = true;
					bt(cnt + 1, sum, temp, i);
					visited[i] = false;
					if (bef >= 0)
						sum -= tsp[bef][i];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		tsp = new int[n][n];
		visited = new boolean[n];

		Arrays.fill(visited, false);

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				tsp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		bt(0, 0, -1, -1);

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}