package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		int a, b, c;
		String name[];
		int scr[][];

		N = Integer.parseInt(br.readLine());
		name = new String[N];
		scr = new int[N][3];

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (scr[o1][0] == scr[o2][0]) {
				if (scr[o1][1] == scr[o2][1]) {
					if (scr[o1][2] == scr[o2][2]) {
						int len = Math.min(name[o1].length(), name[o2].length());
						for (int i = 0; i < len; i++) {
							if (name[o1].charAt(i) == name[o2].charAt(i))
								continue;
							if (name[o1].charAt(i) > name[o2].charAt(i))
								return 1;
							else
								return -1;
						}
						if (name[o1].length() > name[o2].length())
							return 1;
						else
							return -1;
					} else {
						return scr[o2][2] - scr[o1][2];
					}
				} else {
					return scr[o1][1] - scr[o2][1];
				}
			} else {
				return scr[o2][0] - scr[o1][0];
			}
		});

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			name[i] = inp[0];
			scr[i][0] = Integer.parseInt(inp[1]);
			scr[i][1] = Integer.parseInt(inp[2]);
			scr[i][2] = Integer.parseInt(inp[3]);
			pq.add(i);
		}

		while (!pq.isEmpty()) {
			int idx = pq.poll();
			bw.write(name[idx] + "\n");
		}

		bw.flush();
		bw.close();

	}

}
