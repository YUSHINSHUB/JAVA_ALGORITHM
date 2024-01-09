package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1966_Printer_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, m;
		int max = 0;
		int res = 0;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			res = 0;
			max = 0;
			LinkedList<Integer> q = new LinkedList<Integer>();
			String nm[] = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			m++;
			int maxcnt = 0;

			String in[] = br.readLine().split(" ");

			for (int z = 0; z < n; z++) {
				q.offer(Integer.parseInt(in[z]));
				if (max < Integer.parseInt(in[z])) {
					max = Integer.parseInt(in[z]);
					maxcnt = 1;
				} else if (max == Integer.parseInt(in[z])) {
					maxcnt++;
				}
			}

			while (true) {
				int temp = q.poll();
				if (temp != max) {
					q.offer(temp);
					m--;
					if (m == 0) {
						m = q.size();
					}
				} else {
					maxcnt--;
					m--;
					res++;
					if (m == 0)
						break;
					if (maxcnt == 0) {
						max = 0;
						for (int z = 0; z < q.size(); z++) {
							int y = q.poll();
							q.offer(y);
							if (max < y) {
								max = y;
								maxcnt = 1;
							} else if (max == y)
								maxcnt++;
						}
					}
				}
			}
			bw.write(String.valueOf(res + "\n"));
		}

		bw.flush();
		bw.close();
	}
}
