package Mathematics;

import java.io.*;

public class Q2163_Cut_Chocolate_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");

		int a = Integer.parseInt(inp[0]);
		int b = Integer.parseInt(inp[1]);

		int res = a * b - 1;

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}