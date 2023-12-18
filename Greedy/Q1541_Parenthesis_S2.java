package Greedy;

import java.io.*;
import java.util.*;

public class Q1541_Parenthesis_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder in = new StringBuilder(br.readLine());
		int pos = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int temp = 0;
		String t = "";
		int st = 0;

		while (pos < in.length()) {
			if (in.charAt(pos) == '-')
				break;
			if (in.charAt(pos) == '+') {
				st += Integer.parseInt(t);
				t = "";
			} else {
				t += in.charAt(pos);
			}
			pos++;
		}

		if (pos == in.length())
			bw.write((st + Integer.parseInt(t)) + "");
		else {
			if (in.charAt(pos) == '-') {
				st += Integer.parseInt(t);
				t = "";
			}
			pos++;

			for (int i = pos; i < in.length(); i++) {
				if (in.charAt(i) == '+') {
					temp += Integer.parseInt(t);
					t = "";
				} else if (in.charAt(i) == '-') {
					temp += Integer.parseInt(t);
					t = "";
					q.offer(temp);
					temp = 0;
				} else {
					t += in.charAt(i);
				}
			}
			if (!t.equals(""))
				temp += Integer.parseInt(t);
			q.offer(temp);

			while (!q.isEmpty()) {
				st -= q.poll();
			}

			bw.write(st + "");
		}

		bw.flush();
		bw.close();
	}
}