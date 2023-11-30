package aaNotepad;

import java.io.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N, K;
		long res = 0;

		String inp[] = br.readLine().split(" ");
		N = Long.parseLong(inp[0]);
		K = Long.parseLong(inp[1]);

		if (K == 1)
			bw.write("-1");
		else {
			if ((N * K) % (K - 1) != 0)
				res = ((N * K) / (K - 1)) + 1;
			else
				res = (N * K) / (K - 1);
			bw.write(res + "");
		}

		bw.flush();
		bw.close();

	}

}
