package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11279_Maximum_Heap_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int in = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			in = Integer.parseInt(br.readLine());
			if (in != 0) {
				pq.offer(in);
			} else if (pq.isEmpty()) {
				bw.write("0\n");
			} else {
				bw.write(pq.poll() + "\n");
			}
		}

		bw.flush();
		bw.close();

	}
}