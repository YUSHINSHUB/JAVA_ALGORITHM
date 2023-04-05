package Greedy;

import java.io.*;

public class Q2720_Laundry_Owner_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int q, d, n;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int temp = Integer.parseInt(br.readLine());
			q = temp / 25;
			temp %= 25;
			d = temp / 10;
			temp %= 10;
			n = temp / 5;
			temp %= 5;
			bw.write(q + " " + d + " " + n + " " + temp + "\n");
		}

		bw.flush();
		bw.close();
	}
}