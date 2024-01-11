package Mathematics;

import java.io.*;

public class Q3003_Chess_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] rig = { 1, 1, 2, 2, 2, 8 };

		String[] inp = br.readLine().split(" ");

		for (int i = 0; i < 6; i++) {
			bw.write(String.valueOf(rig[i] - Integer.parseInt(inp[i]) + " "));
		}

		bw.flush();
		bw.close();

	}

}
