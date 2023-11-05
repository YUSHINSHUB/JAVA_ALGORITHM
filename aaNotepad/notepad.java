package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int A;
	static int B;

	static String bfs() {

		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, String> hm = new HashMap<>();

		int t = A * 2;
		t %= 10000;
		q.add(t);
		hm.put(t, "D");
		if (t == B)
			return "D";

		t = A - 1;
		if (t == -1)
			t = 9999;
		q.add(t);
		hm.put(t, "S");
		if (t == B)
			return "S";

		t = A / 1000 + (A % 1000 * 10);
		q.add(t);
		hm.put(t, "L");
		if (t == B)
			return "L";

		t = A / 10 + (A % 10 * 1000);
		q.add(t);
		hm.put(t, "R");
		if (t == B)
			return "R";

		while (true) {
			t = q.poll();

			int temp = t * 2;
			temp %= 10000;
			if (temp == B)
				return hm.get(t) + "D";
			else if (hm.getOrDefault(temp, "").equals("")) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "D");
			}

			temp = t - 1;
			if (temp == 0)
				temp = 9999;

			if (temp == B)
				return hm.get(t) + "S";
			else if (hm.getOrDefault(temp, "").equals("")) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "S");
			}

			temp = t / 1000 + (t % 1000 * 10);
			if (temp == B)
				return hm.get(t) + "L";
			else if (hm.getOrDefault(temp, "").equals("")) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "L");
			}

			temp = t / 10 + (t % 10 * 1000);
			if (temp == B)
				return hm.get(t) + "R";
			else if (hm.getOrDefault(temp, "").equals("")) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "R");
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String inp[] = br.readLine().split(" ");
			A = Integer.parseInt(inp[0]);
			B = Integer.parseInt(inp[1]);
			bw.write(bfs() + "\n");
		}

		bw.flush();
		bw.close();

	}

}
