package Mathematics;

import java.io.*;

public class Q11050_Binomial_Coefficient_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");

		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		int nk = n - k;
		int tn = 1, tk = 1, tnk = 1;

		for (int i = 2; i <= n; i++) {
			tn *= i;
		}

		for (int i = 2; i <= k; i++) {
			tk *= i;
		}

		for (int i = 2; i <= nk; i++) {
			tnk *= i;
		}

		int res = tn / (tk * tnk);

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}
