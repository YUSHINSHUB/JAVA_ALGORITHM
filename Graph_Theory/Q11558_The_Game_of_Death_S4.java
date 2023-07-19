package Graph_Theory;

import java.io.*;
import java.util.*;

public class Q11558_The_Game_of_Death_S4 {

	public static void main(String[] args) throws IOException {

		// 해당 문제는 노드가 단방향이기 때문에 배열(visited[])을 이용해서 중복방문 확인 시 불가능 처리를 하면 된다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int res = 0;
			int idx = 1;
			int pt[] = new int[n + 1];
			int visited[] = new int[n + 1];
			Arrays.fill(visited, 0);
			for (int j = 1; j <= n; j++) {
				pt[j] = Integer.parseInt(br.readLine());
			}

			while (true) {
				if (idx == n)
					break;
				if (visited[idx] == 1) {
					res = 0;
					break;
				}

				visited[idx] = 1;
				idx = pt[idx];
				res++;
			}

			bw.write(res + "\n");

		}

		bw.flush();
		bw.close();
	}
}
