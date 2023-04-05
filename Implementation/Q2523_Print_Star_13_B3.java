package Implementation;

import java.io.*;

public class Q2523_Print_Star_13_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			for (int z = 0; z < i; z++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		for (int i = n - 1; i > 0; i--) {
			for (int z = 0; z < i; z++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}