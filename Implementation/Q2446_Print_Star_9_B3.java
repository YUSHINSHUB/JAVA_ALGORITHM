package Implementation;

import java.io.*;

public class Q2446_Print_Star_9_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int index = (n - 1) * 2 + 1;

		for (int i = 0; i < n; i++) {
			for (int z = 0; z < i; z++) {
				bw.write(" ");
			}

			for (int z = 0; z < index - (i * 2); z++) {
				bw.write("*");
			}

			bw.write("\n");

		}

		for (int i = n - 2; i >= 0; i--) {
			for (int z = 0; z < i; z++) {
				bw.write(" ");
			}

			for (int z = 0; z < index - (i * 2); z++) {
				bw.write("*");
			}

			bw.write("\n");

		}

		bw.flush();
		bw.close();

	}
}