package Graph_Theory;

import java.io.*;
import java.util.*;

public class Q16953_AtoB_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		long a = Long.parseLong(inp[0]);
		long b = Long.parseLong(inp[1]);
		int cnt = 1;
		boolean pass = false;

		Queue<Long> stk = new LinkedList<>();
		stk.add(a);

		while (true) {

			if (stk.isEmpty())
				break;

			int s = stk.size();
			for (int i = 0; i < s; i++) {
				long temp = stk.poll();
				if (temp == b) {
					pass = true;
					break;
				}
				if (temp * 2 <= b) {
					stk.add(temp * 2);
				}
				if ((temp * 10) + 1 <= b) {
					stk.add((temp * 10) + 1);
				}
			}
			if (pass)
				break;
			cnt++;
		}

		if (pass)
			bw.write(cnt + "");
		else
			bw.write("-1");

		bw.flush();
		bw.close();

	}
}