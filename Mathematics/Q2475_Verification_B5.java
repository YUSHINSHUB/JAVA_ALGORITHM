package Mathematics;

import java.io.*;

public class Q2475_Verification_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String elm[] = br.readLine().split(" ");

		int sig = 0;

		for (int i = 0; i < 5; i++) {
			sig = sig + (Integer.parseInt(elm[i]) * Integer.parseInt(elm[i]));
		}

		sig = sig % 10;

		bw.write(String.valueOf(sig));

		bw.flush();
		bw.close();

	}

}
