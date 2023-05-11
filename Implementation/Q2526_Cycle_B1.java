package Implementation;

import java.io.*;
import java.util.*;

public class Q2526_Cycle_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int p = Integer.parseInt(inp[1]);
		int res = 0;

		boolean chk[] = new boolean[n * p + 1];
		Arrays.fill(chk, false);

		chk[n] = true;

		int idx = n;

		while (true) {
			idx *= n;
			idx %= p;
			if (chk[idx]) {
				int temp = idx;
				res = 1;
				idx *= n;
				idx %= p;
				while (idx != temp) {
					res++;
					idx *= n;
					idx %= p;
				}
				break;
			} else {
				chk[idx] = true;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
