package Mathematics;

import java.io.*;

public class Q15894_PE_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Integer.parseInt(br.readLine());

		bw.write(n * 4 + "");
		bw.flush();
		bw.close();

	}
}