package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String in[] = br.readLine().split(" ");

			if (in[0].equals("push"))
				q.addLast(Integer.parseInt(in[1]));
			else if (in[0].equals("pop")) {
				if (q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.pollFirst() + "\n");
			} else if (in[0].equals("size"))
				bw.write(q.size() + "\n");
			else if (in[0].equals("empty")) {
				if (q.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			} else if (in[0].equals("front")) {
				if (q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.getFirst() + "\n");
			} else if (in[0].equals("back")) {
				if (q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.getLast() + "\n");
			}
		}

		bw.flush();
		bw.close();

	}
}