package Data_Structures;

import java.io.*;
import java.util.*;

public class Q2346_Balloon_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> dq = new ArrayDeque<Integer>();
		int n = Integer.parseInt(br.readLine());
		int cod[] = new int[n];
		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			cod[i] = Integer.parseInt(inp[i]);
			dq.addLast(i + 1);
		}

		int idx = 0;
		int pos = 0;

		while (true) {

			pos = dq.pollFirst();
			bw.write(pos + " ");
			idx = cod[pos - 1];

			if (dq.isEmpty())
				break;
			else {
				if (idx > 0) {
					for (int i = 0; i < idx - 1; i++) {
						dq.addLast(dq.pollFirst());
					}
				} else {
					idx *= (-1);
					for (int i = 0; i < idx; i++) {
						dq.addFirst(dq.pollLast());
					}
				}
			}
		}

		bw.flush();
		bw.close();

	}
}