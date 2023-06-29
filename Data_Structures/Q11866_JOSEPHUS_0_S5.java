package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11866_JOSEPHUS_0_S5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> q = new LinkedList<Integer>();

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		int cnt = 1;

		for (int i = 1; i <= n; i++)
			q.add(i);

		bw.write("<");
		while (!q.isEmpty()) {
			if (cnt == k) {
				cnt = 1;
				bw.write(q.poll() + "");
				if (!q.isEmpty())
					bw.write(", ");
			} else {
				q.add(q.poll());
				cnt++;
			}
		}
		bw.write(">");

		bw.flush();
		bw.close();

	}
}