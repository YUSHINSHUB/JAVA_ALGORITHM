package Graph_Theory;

import java.io.*;

public class Q17848_Flight_Turbulence_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		int res = 0;

		int pas[] = new int[n + 1];
		in = br.readLine().split(" ");

		for (int i = 1; i <= n; i++)
			pas[i] = Integer.parseInt(in[i - 1]);

		while (pas[m] != m) {
			int temp = pas[m];
			pas[m] = m;
			m = temp;
			res++;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}