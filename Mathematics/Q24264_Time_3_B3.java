package Mathematics;

import java.io.*;

public class Q24264_Time_3_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		bw.write(n * n + "\n2");
		bw.flush();
		bw.close();

	}
}