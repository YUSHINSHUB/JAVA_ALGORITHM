package Ad_hoc;

import java.io.*;
import java.util.*;

public class Q16956_Wolf_and_Sheep_S3 {

	static Queue<int[]> q = new LinkedList<int[]>();
	static int bx[] = new int[] { -1, 2, -1, 0 };
	static int by[] = new int[] { 0, 0, -1, 2 };
	static char swd[][];

	static boolean bfs(int r, int c) {
		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int x = temp[0];
			int y = temp[1];
			if (x == -1 && y == -1)
				break;

			for (int i = 0; i < 4; i++) {
				x += bx[i];
				y += by[i];
				if (x >= 0 && x < r && y >= 0 && y < c) {
					if (swd[x][y] == 'S') {
						return false;
					} else if (swd[x][y] == '.') {
						swd[x][y] = 'D';
					}
				}
			}

		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		int r = Integer.parseInt(in[0]);
		int c = Integer.parseInt(in[1]);
		swd = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s[] = br.readLine().split("");
			for (int z = 0; z < c; z++) {
				swd[i][z] = s[z].charAt(0);
				if (swd[i][z] == 'W')
					q.offer(new int[] { i, z });
			}
		}

		if (bfs(r, c) == true) {
			bw.write("1\n");
			for (int i = 0; i < r; i++) {
				for (int z = 0; z < c; z++) {
					bw.write(String.valueOf(Character.toString(swd[i][z])));
				}
				bw.write("\n");
			}
		} else {
			bw.write("0");
		}

		bw.flush();
		bw.close();
	}
}
