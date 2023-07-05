package Graph_Theory;

import java.io.*;
import java.util.*;

class bef {
	int pos;
	int dis;

	bef(int pos, int dis) {
		this.pos = pos;
		this.dis = dis;
	}

	int getpos() {
		return pos;
	}

	int getdis() {
		return dis;
	}

}

public class Q16173_Jump_King_Small_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int visited[][] = new int[n][n];
		int grp[][] = new int[n][n];
		Stack<bef> before = new Stack<bef>();

		for (int i = 0; i < n; i++)
			Arrays.fill(visited[i], 0);

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		int y = 0;
		int x = 0;
		String res = "";

		while (true) {
			if (grp[y][x] == -1) {
				res = "HaruHaru";
				break;
			}

			if (x + grp[y][x] < n && visited[y][x + grp[y][x]] == 0 && grp[y][x] != 0) {
				before.add(new bef(1, grp[y][x]));
				x += grp[y][x];
				continue;
			}

			if (y + grp[y][x] < n && visited[y + grp[y][x]][x] == 0 && grp[y][x] != 0) {
				before.add(new bef(2, grp[y][x]));
				y += grp[y][x];
				continue;
			}

			if (!before.isEmpty()) {
				visited[y][x] = 1;
				bef temp = before.pop();
				if (temp.getpos() == 1) {
					x -= temp.getdis();
				} else {
					y -= temp.getdis();
				}
			} else {
				res = "Hing";
				break;
			}
		}

		bw.write(res);
		bw.flush();
		bw.close();
	}
}
