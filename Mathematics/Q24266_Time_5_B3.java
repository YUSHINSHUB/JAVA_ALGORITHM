package Mathematics;

import java.io.*;

public class Q24266_Time_5_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		bw.write(n * n * n + "\n3");
		bw.flush();
		bw.close();

	}
}