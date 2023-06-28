package Greedy;

import java.io.*;

public class Q1789_Sum_of_Numbers_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long s = Long.parseLong(br.readLine());
		int cnt = 1;
		long sum = 0;

		while (true) {
			sum += cnt;
			cnt++;
			if (cnt > s - sum) {
				cnt--;
				break;
			}
		}

		bw.write(cnt + "");

		bw.flush();
		bw.close();
	}
}