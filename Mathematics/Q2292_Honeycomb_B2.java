package Mathematics;

import java.io.*;

public class Q2292_Honeycomb_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int cnt = 1;
		int max = 1;
		int up = 6;

		while (n > max) {
			max += up;
			up += 6;
			cnt++;
		}

		bw.write(String.valueOf(cnt));

		bw.flush();
		bw.close();

	}

}
