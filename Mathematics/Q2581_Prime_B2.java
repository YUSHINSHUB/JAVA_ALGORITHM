package Mathematics;

import java.io.*;
import java.util.*;

public class Q2581_Prime_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m, n;
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());

		int high = Math.max(m, n);

		boolean pri[] = new boolean[high + 1];
		pri[0] = true;
		if (high >= 1) {
			pri[1] = true;
		}
		if (high >= 2) {
			pri[2] = false;
		}

		for (int i = 4; i <= high; i += 2) {
			pri[i] = true;
		}

		for (int i = 3; i <= high; i += 2) {
			if (pri[i] == false) {
				for (int z = i * 2; z <= high; z += i) {
					pri[z] = true;
				}
			}
		}

		int sum = 0;
		int res = 0;

		for (int i = Math.min(m, n); i <= high; i++) {
			if (pri[i] == false) {
				sum += i;
				if (res == 0) {
					res = i;
				}
			}
		}

		String out = sum + "\n" + res;
		if (sum == 0)
			out = "-1";

		bw.write(out);

		bw.flush();
		bw.close();

	}
}
