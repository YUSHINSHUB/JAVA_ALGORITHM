package Data_Structures;

import java.io.*;
import java.util.*;

class Q1158_Josephus_S4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		sb.append("<");

		for (int i = 1; i <= a; i++) {
			q.add(i);
		}

		for (int i = 1; i < a; i++) {
			for (int x = 1; x < b; x++) {
				q.add(q.poll());
			}
			sb.append(q.poll() + ", ");

		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}