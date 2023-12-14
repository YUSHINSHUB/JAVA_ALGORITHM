package Mathematics;

import java.io.*;

public class Q2588_Multiplication_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		bw.write(a * (b % 10) + "\n");
		bw.write(a * (b % 100 / 10) + "\n");
		bw.write(a * (b / 100) + "\n");
		bw.write(a * b + "\n");

		bw.flush();
		bw.close();

	}

}