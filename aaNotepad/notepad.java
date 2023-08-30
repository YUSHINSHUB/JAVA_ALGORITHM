package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

class lec {
	int s;
	int t;

	lec(int s, int t) {
		this.s = s;
		this.t = t;
	}
}

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		lec list[] = new lec[n];

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			int s = Integer.parseInt(inp[0]);
			int t = Integer.parseInt(inp[1]);

			list[i] = new lec(s, t);
		}

		Arrays.sort(list, new Comparator<lec>() {
			public int compare(lec o1, lec o2) {
				if (o1.s != o2.s)
					return o1.s - o2.s;
				else
					return o1.t - o2.t;
			}
		});

		pq.add(list[0].t);

		for (int i = 1; i < n; i++) {
			if (pq.peek() <= list[i].s) {
				pq.poll();
			}
			pq.add(list[i].t);
		}

		bw.write(pq.size() + "");

		bw.flush();
		bw.close();

	}
}
