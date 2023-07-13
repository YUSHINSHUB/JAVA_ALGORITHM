package Number_Theory;

import java.io.*;

public class Q9020_Goldbachs_Conjecture_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int chk[] = new int[10001];
		chk[1] = 1;
		chk[2] = 2;

		for (int i = 4; i <= 10000; i += 2) {
			chk[i] = 1;
		}

		for (int i = 3; i <= 10000; i++) {
			if (chk[i] != 1) {
				chk[i] = 2;
				for (int z = i * 2; z <= 10000; z += i) {
					chk[z] = 1;
				}
			}
		}

		int n = Integer.parseInt(br.readLine());
		int in = 0;

		for (int i = 0; i < n; i++) {
			in = Integer.parseInt(br.readLine());
			for (int z = in / 2; z <= in; z++) {
				if (chk[z] == 2 && chk[in - z] == 2) {
					bw.write((in - z) + " " + z + "\n");
					break;
				}
			}
		}

		bw.flush();
		bw.close();

	}
}
