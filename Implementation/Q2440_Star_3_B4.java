package Implementation;

import java.io.*;

public class Q2440_Star_3_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = n; i > 0; i--) {
			for (int z = 0; z < i; z++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}

}
