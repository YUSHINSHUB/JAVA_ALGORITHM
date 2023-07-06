package Queue;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10845_QUEUE_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] commands = new String[n];

		Queue<Integer> q = new LinkedList<>();

		int back = 0;

		for (int i = 0; i < n; i++) {
			commands[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			switch (commands[i]) {
			case "pop":
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(q.poll()) + "\n");
				}
				break;

			case "size":
				bw.write(String.valueOf(q.size()) + "\n");
				break;

			case "empty":
				if (q.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;

			case "front":
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(q.peek()) + "\n");
				}
				break;

			case "back":
				if (q.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(back) + "\n");
				}
				break;

			default:
				String[] temp = commands[i].split(" ");
				q.offer(Integer.parseInt(temp[1]));
				back = Integer.parseInt(temp[1]);
				break;

			}
		}

		bw.flush();
		bw.close();

	}
}
