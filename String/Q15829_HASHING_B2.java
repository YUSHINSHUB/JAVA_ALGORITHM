package String;

import java.io.*;

public class Q15829_HASHING_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String in = br.readLine();
		long res = 0;
		long temp = 1;

		for (int i = 0; i < n; i++) {
			res += ((int) (in.charAt(i) - 96) * temp) % 1234567891;
			temp = temp * 31 % 1234567891;
		}

		bw.write(String.valueOf(res % 1234567891));

		bw.flush();
		bw.close();
	}
}