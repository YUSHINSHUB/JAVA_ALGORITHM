package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

class circle {
	int x;
	int y;
	int r;

	circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	// 객체 간의 동일성을 확인 (Check for object equality)
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		circle position = (circle) o;
		return x == position.x && y == position.y;
	}

	// 객체의 해시 코드 생성 (Generate hash code for the object)
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

public class notepad {

	static int group[];
	static Queue<Integer> q[];
	static int N;
	static int res = 0;

	static void dfs(int idx) {
		while (!q[idx].isEmpty()) {
			int t = q[idx].poll();
			if (group[t] == 0) {
				group[t] = 1;
				dfs(t);
			}
		}
	}

	static void search() {
		for (int i = 0; i < N; i++) {
			if (group[i] == 0) {
				group[i] = 1;
				dfs(i);
				res++;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			circle p[] = new circle[N];
			group = new int[N];
			Arrays.fill(group, 0);
			q = new LinkedList[N];

			for (int j = 0; j < N; j++) {
				String inp[] = br.readLine().split(" ");
				p[j] = new circle(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
				q[j] = new LinkedList<>();
			}

			for (int j = 0; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (Math.pow(Math.abs(p[j].x - p[k].x), 2) + Math.pow(Math.abs(p[j].y - p[k].y), 2) <= Math
							.pow(p[j].r + p[k].r, 2)) {
						q[j].add(k);
						q[k].add(j);
					}
				}
			}

			search();

			bw.write(res + "\n");

		}

		bw.flush();
		bw.close();

	}

}
