package Arithmetic;

import java.io.*;

public class Q25304_Receipt_B4 {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, fee;
		int res = 0;

		fee = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String in[] = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			res += a * b;
		}
		if (res == fee)
			bw.write("Yes");
		else
			bw.write("No");

		bw.flush();
		bw.close();

	}
}