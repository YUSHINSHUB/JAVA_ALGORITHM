package Implementation;

import java.io.*;

public class Q10870_FIBONACCI_5_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] res = new int[21];
		res[0] = 0;
		res[1] = 1;

		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		bw.write(String.valueOf(res[n]));

		bw.flush();
		bw.close();
	}

}