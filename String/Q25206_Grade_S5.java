package String;

import java.io.*;

public class Q25206_Grade_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double sum = 0;
		double per = 0;
		int idx = 20;

		for (int i = 0; i < 20; i++) {

			String inp[] = br.readLine().split(" ");

			double temp = Double.parseDouble(inp[1]);

			if (!inp[2].equals("P"))
				per += temp;

			if (inp[2].equals("A0")) {
				temp /= 4.5;
				temp *= 4;
			} else if (inp[2].equals("B+")) {
				temp /= 4.5;
				temp *= 3.5;
			} else if (inp[2].equals("B0")) {
				temp /= 4.5;
				temp *= 3;
			} else if (inp[2].equals("C+")) {
				temp /= 4.5;
				temp *= 2.5;
			} else if (inp[2].equals("C0")) {
				temp /= 4.5;
				temp *= 2;
			} else if (inp[2].equals("D+")) {
				temp /= 4.5;
				temp *= 1.5;
			} else if (inp[2].equals("D0")) {
				temp /= 4.5;
				temp *= 1;
			} else if (inp[2].equals("F") || inp[2].equals("P")) {
				temp = 0;
			}

			sum += temp;

		}

		per = 4.5 / per;
		per *= sum;
		bw.write(per + "");

		bw.flush();
		bw.close();
	}
}
