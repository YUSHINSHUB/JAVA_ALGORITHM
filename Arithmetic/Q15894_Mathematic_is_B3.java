package Arithmetic;

import java.io.*;

public class Q15894_Mathematic_is_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		bw.write(n * 4 + "");
		bw.flush();
		bw.close();

	}
}