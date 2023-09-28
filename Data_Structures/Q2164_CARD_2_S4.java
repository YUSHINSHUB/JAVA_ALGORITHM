package Data_Structures;

import java.io.*;
import java.util.*;

public class Q2164_CARD_2_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() != 1) {
			q.poll();
			if (q.size() == 1)
				break;
			q.offer(q.poll());
		}

		bw.write(q.poll() + "");
		bw.flush();
		bw.close();

	}
}
