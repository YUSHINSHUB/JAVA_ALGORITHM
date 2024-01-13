package Data_Structures;

import java.io.*;
import java.util.*;

public class Q12789_Snack_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int idx = 1;

		Deque<Integer> line = new LinkedList<Integer>();
		Deque<Integer> alt = new LinkedList<Integer>();

		String inp[] = br.readLine().split(" ");
		String res = "Nice";

		for (int i = 0; i < n; i++) {
			line.addLast(Integer.parseInt(inp[i]));
		}

		while (line.getFirst() == idx) {
			line.pollFirst();
			idx++;
			if (line.isEmpty())
				break;
		}

		while (idx <= n) {

			if (!line.isEmpty()) {
				if (alt.isEmpty()) {
					while (line.getFirst() != idx) {
						alt.addFirst(line.pollFirst());
						if (line.isEmpty())
							break;
					}
				} else {
					while (line.getFirst() != idx && alt.getFirst() != idx) {
						alt.addFirst(line.pollFirst());
						if (line.isEmpty())
							break;
					}
				}

			}

			if (line.isEmpty() && alt.getFirst() != idx) {
				res = "Sad";
				break;
			} else if (!alt.isEmpty()) {
				if (alt.getFirst() == idx) {
					alt.pollFirst();
					idx++;
				} else {
					line.pollFirst();
					idx++;
				}
			} else {
				line.pollFirst();
				idx++;
			}

		}

		bw.write(res);

		bw.flush();
		bw.close();
	}
}