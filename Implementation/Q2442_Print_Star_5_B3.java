package Implementation;

import java.io.*;

public class Q2442_Print_Star_5_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			for (int z = 0; z < (n - i); z++) {
				bw.write(" ");
			}
			for (int x = 0; x < (2 * i - 1); x++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}