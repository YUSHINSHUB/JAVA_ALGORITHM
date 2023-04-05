package Number_Theory;

import java.io.*;

public class Q2960_Sieve_of_Eratosthenes_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		int cnt = 0;
		int res = 0;

		boolean chk[] = new boolean[n + 1];
		boolean end = false;

		for (int i = 2; i <= n; i += 2) {

			chk[i] = true;
			cnt++;
			if (cnt == k) {
				res = i;
				break;
			}
		}

		if (cnt != k) {
			for (int i = 3; i <= n; i += 2) {
				if (chk[i] == false) {
					for (int z = i; z <= n; z += i) {
						if (chk[z] == false) {
							chk[z] = true;
							cnt++;
							if (cnt == k) {
								res = z;
								end = true;
								break;
							}
						}
					}
					if (end == true)
						break;
				}
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
