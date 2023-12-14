package Implementation;

import java.io.*;

public class Q2441_Star_4_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = n; i > 0; i--) {
			for (int z = n - i; z > 0; z--) {
				bw.write(" ");
			}
			for (int x = 0; x < i; x++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}

}
