package Greedy;

import java.io.*;

public class Q14720_Milk_Festival_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int idx = 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			if (idx == Integer.parseInt(inp[i])) {
				res++;
				idx++;
			}
			if (idx == 3)
				idx = 0;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}