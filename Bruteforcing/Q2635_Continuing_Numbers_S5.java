package Bruteforcing;

import java.io.*;
import java.util.*;

public class Q2635_Continuing_Numbers_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);

		int a = n, b = n, res = 0, acnt = 0, bcnt = 0;

		for (int i = n / 2; i <= n; i++) {
			acnt = bcnt;
			bcnt = 0;
			a = n;
			b = i;
			while (true) {
				int temp = a;
				a = b;
				b = temp - b;
				bcnt++;
				if (b < 0)
					break;
			}
			if (bcnt < acnt) {
				res = i - 1;
				break;
			} else if (i == n) {
				res = i;
				break;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		q.add(res);
		a = n;
		b = res;
		bcnt = 2;
		while (true) {
			int temp = a;
			a = b;
			b = temp - b;
			if (b < 0)
				break;
			q.add(b);
			bcnt++;

		}

		bw.write(bcnt + "\n");
		while (!q.isEmpty())
			bw.write(q.poll() + " ");

		bw.flush();
		bw.close();
	}
}
