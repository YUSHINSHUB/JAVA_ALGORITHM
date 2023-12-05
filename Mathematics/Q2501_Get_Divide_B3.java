package Mathematics;

import java.io.*;

public class Q2501_Get_Divide_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		int idx = 0;
		int res = 0;

		for (int i = 1; i <= n; i++) {

			if (n % i == 0)
				idx++;
			if (idx == k) {
				res = i;
				break;
			}

		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}