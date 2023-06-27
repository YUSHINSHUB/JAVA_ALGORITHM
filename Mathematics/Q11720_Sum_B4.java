package Mathematics;

import java.io.*;

public class Q11720_Sum_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;
		int n = Integer.parseInt(br.readLine());
		String x[] = br.readLine().split("");

		for (int i = 0; i < n; i++) {
			res = res + Integer.parseInt(x[i]);
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
	}

}