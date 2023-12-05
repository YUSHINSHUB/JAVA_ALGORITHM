package Mathematics;

import java.io.*;

public class Q9506_Sum_of_Divides_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int in;
		int sum;

		while (true) {
			in = Integer.parseInt(br.readLine());
			if (in == -1) {
				break;
			}
			sum = 0;
			boolean chk[] = new boolean[in / 2 + 1];

			for (int i = 1; i <= in / 2; i++) {
				if (in % i == 0) {
					chk[i] = true;
					sum += i;
				}
			}

			if (sum == in) {
				bw.write(String.valueOf(in) + " = 1");
				for (int i = 2; i <= in / 2; i++) {
					if (chk[i] == true) {
						bw.write(" + " + String.valueOf(i));
					}
				}
				bw.write("\n");
			} else {
				bw.write(String.valueOf(in) + " is NOT perfect.\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
