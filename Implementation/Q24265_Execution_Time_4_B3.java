package Implementation;

import java.io.*;

public class Q24265_Execution_Time_4_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());
		long res = 0;

		for (int i = 1; i <= n - 1; i++) {
			res += i;
		}

		bw.write(res + "\n2");
		bw.flush();
		bw.close();

	}
}