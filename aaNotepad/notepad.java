package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (!pq.isEmpty()) {
			int a, b;
			a = pq.poll();
			if (pq.isEmpty()) {
				res += a;
				break;
			}

			b = pq.poll();
			if (a > 1 && b > 1) {
				res += a * b;
			} else {
				if (a == 1) {
					res += a;
					pq.add(b);
					break;
				} else if (b == 1) {
					res += a;
					res += b;
					break;
				} else if (a < 1) {
					pq.add(a);
					pq.add(b);
					break;
				}

			}

		}

		if (!pq.isEmpty()) {
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			while (!pq.isEmpty())
				pq2.add(pq.poll());
			while (!pq2.isEmpty()) {
				int a, b;
				a = pq2.poll();
				if (pq2.isEmpty()) {
					res += a;
					break;
				}

				b = pq2.poll();
				res += a * b;

			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
