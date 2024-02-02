package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static ArrayList<Integer> ylist = new ArrayList<>();
	static ArrayList<Integer> xlist = new ArrayList<>();
	static Boolean visited[];
	static int n, fy, fx;

	static Boolean bfs(int y, int x) {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);

		while (!yq.isEmpty()) {
			int cy = yq.poll();
			int cx = xq.poll();
			if ((Math.abs(cy - fy) + Math.abs(cx - fx)) <= 1000)
				return true;
			for (int i = 0; i < n; i++) {
				if (visited[i])
					continue;
				if ((Math.abs(cy - ylist.get(i)) + Math.abs(cx - xlist.get(i))) <= 1000) {
					visited[i] = true;
					yq.add(ylist.get(i));
					xq.add(xlist.get(i));
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t, y, x;
		String inp[];

		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			ylist.clear();
			xlist.clear();
			n = Integer.parseInt(br.readLine());
			visited = new Boolean[n + 1];
			Arrays.fill(visited, false);
			inp = br.readLine().split(" ");
			y = Integer.parseInt(inp[0]);
			x = Integer.parseInt(inp[1]);
			for (int j = 0; j < n; j++) {
				inp = br.readLine().split(" ");
				ylist.add(Integer.parseInt(inp[0]));
				xlist.add(Integer.parseInt(inp[1]));
			}
			inp = br.readLine().split(" ");
			fy = Integer.parseInt(inp[0]);
			fx = Integer.parseInt(inp[1]);
			if (bfs(y, x))
				bw.write("happy\n");
			else
				bw.write("sad\n");
		}

		bw.flush();
		bw.close();
	}
}