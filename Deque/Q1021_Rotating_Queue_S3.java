package Deque;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1021_Rotating_Queue_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> d = new LinkedList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		in = br.readLine().split(" ");
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < m; i++) {
			q.offer(Integer.parseInt(in[i]));
		}

		for (int i = 1; i <= n; i++) {
			d.offerLast(i);
			hm.put(i, i);
		}

		int res = 0;

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (hm.get(temp) <= d.size() - hm.get(temp) + 1) {
				while (d.getFirst() != temp) {
					d.offerLast(d.pollFirst());
					res++;
				}
				d.pollFirst();
			} else {
				while (d.getFirst() != temp) {
					d.offerFirst(d.pollLast());
					res++;
				}
				d.pollFirst();
			}
			for (int i = 1; i <= d.size(); i++) {
				int t = d.pollFirst();
				d.offerLast(t);
				hm.put(t, i);
			}

		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}