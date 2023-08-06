package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> stk = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			int c = Integer.parseInt(inp[0]);

			switch (c) {
			case 1:
				stk.addFirst(Integer.parseInt(inp[1]));
				break;
			case 2:
				stk.addLast(Integer.parseInt(inp[1]));
				break;
			case 3:
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.pollFirst() + "\n");
				break;
			case 4:
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.pollLast() + "\n");
				break;
			case 5:
				bw.write(stk.size() + "\n");
				break;
			case 6:
				if (stk.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case 7:
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.peekFirst() + "\n");
				break;
			case 8:
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.peekLast() + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();

	}
}