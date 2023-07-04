package Implementation;

import java.io.*;

public class Q24267_Execution_Time_6_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());
		long res = 0;
		long cur = 0;

		for (long i = 1; i <= n - 2; i++) {
			cur += i;
			res += cur;
		}

		bw.write(res + "\n3");

		bw.flush();
		bw.close();

	}
}