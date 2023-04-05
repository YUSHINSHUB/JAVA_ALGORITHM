package String;

import java.io.*;

public class Q2810_Cup_Holder_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String in = br.readLine();
		int cnt = 1;

		for (int i = 0; i < n; i++) {
			if (in.charAt(i) == 'S') {
				cnt++;
			} else {
				cnt++;
				i++;
			}
		}

		bw.write(String.valueOf(Math.min(cnt, n)));

		bw.flush();
		bw.close();
	}
}