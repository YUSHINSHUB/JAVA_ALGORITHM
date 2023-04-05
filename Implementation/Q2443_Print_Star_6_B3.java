package Implementation;

import java.io.*;

public class Q2443_Print_Star_6_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int p = Integer.parseInt(br.readLine());

		for (int i = p; i > 0; i--) {
			for (int z = p - i; z > 0; z--) {
				bw.write(" ");
			}
			for (int z = 0; z < (2 * i) - 1; z++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}